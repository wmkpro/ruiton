package com.ruiton.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ruiton.bean.Paginer;
import com.ruiton.bean.RequestBean;
import com.ruiton.bean.ResultCode;
import com.ruiton.service.OrderService;
import com.ruiton.utils.CommonUtils;
import com.ruiton.utils.DateUtil;
import com.ruiton.utils.ExcelUtils;
import com.ruiton.vo.OrderVo;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController{
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/orderlistUI")
	public ModelAndView orderlistUI(){
		modelAndView("order/orderlist");
		return modelAndView;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/orderlist")
	public void orderlist(){
		try{
			OrderVo orderVo= new OrderVo();
			orderVo.setWhereSql(getSearchRules());
			orderVo.setOrderBySql(" order by id desc ");
			Paginer<OrderVo> paginer=getPaginer();
			paginer.setObj(orderVo);
			paginer=orderService.getPaginer(paginer);
			outPage(paginer);
		}catch (Throwable e) {
			e.printStackTrace();
			log.error("查询订单列表错误", e);
		}
	}
	
	//添加数据页面
	@RequestMapping("/addOrderUI")
	public ModelAndView addOrderUI(){
		return modelAndView("order/addOrderUI");
	}
	
	//添加数据
	@RequestMapping("/addOrder")
	public void addOrder(OrderVo orderVo){
		ResultCode resultCode=ResultCode.newSuccess();
		try{
			Long rt=orderService.add(orderVo);
			if(rt==null||rt<=0){
				resultCode.setFail("添加失败,请联系技术人员");
			}
		}catch (Throwable e) {
			e.printStackTrace();
			log.error("添加异常,data={},异常信息={}",orderVo, e);
			resultCode.setFail("添加异常,请联系技术人员");
		}
		resWriteObjectJson(resultCode);
	}
	
	//修改数据页面
	@RequestMapping("/updOrderUI")
	public ModelAndView updOrderUI(OrderVo orderVo){
			orderVo=orderService.get(orderVo);
			modelAndView("order/updOrderUI");
			modelAndView.addObject("vo", orderVo);
			return modelAndView;
	}
		
	//修改数据
	@RequestMapping("/updOrder")
	public void updOrder(OrderVo orderVo){
			ResultCode resultCode=ResultCode.newSuccess();
			try{
				Long rt=orderService.updateByUqKey(orderVo);
				if(rt==null||rt<=0){
					resultCode.setFail("修改失败,请联系技术人员");
				}
			}catch (Throwable e) {
				e.printStackTrace();
				log.error("修改异常,data={},异常信息={}",orderVo, e);
				resultCode.setFail("修改异常,请联系技术人员");
			}
			resWriteObjectJson(resultCode);
	}
	
	//删除数据
	@RequestMapping("/delOrder")
	public void delOrder(RequestBean requestBean){
		ResultCode resultCode=ResultCode.newSuccess();
		try{
			String ids=requestBean.getIds();
			OrderVo t=new OrderVo();
			t.setWhereSql(" id in("+ids+")");
			int rt=orderService.del(t);
			if(rt<=0){
				resultCode.setFail("删除失败,请联系技术人员");
			}
		}catch (Throwable e) {
			e.printStackTrace();
			log.error("删除异常,data={},异常信息={}",requestBean, e);
			resultCode.setFail("删除异常,请联系技术人员");
		}
		resWriteObjectJson(resultCode);
	}
	
	
	
	//导出
	@RequestMapping("/exports")
	public void exports(){
		try{
			OrderVo orderVo= new OrderVo();
			orderVo.setPageStartRow(0);
			orderVo.setPageEndRow(10000);
			orderVo.setWhereSql(getSearchRules());
			List<Map<String, Object>> mapList=orderService.getMapList(orderVo);
			HSSFWorkbook book = new HSSFWorkbook();
			String fileName="国内订单信息";
	        String[] heads = { "序号", "区域", "单位", "客户", "重量", "患者", "订单号", "付款单位", "接单日期"
	        				  ,"出货日期","有效日期","型号","全口/单颌","材料","价格","付款情况","付款日期","备注","eBrace/eLoc","跟单员","销售员"};
	        String[] fileds = { "no", "area", "address", "customerName", "weight", "patient", "orderNo","paymentUnit", "receiptTime"
	        					,"shipmentTime","effectiveTime","model","singlejaw", "material","price","paymentDesc","paymentTime","remark","eBrace","followPerson","salePerson"};
	         int[] widths = { 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000,5000
	        		         ,5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000,5000, 5000, 5000};
	         if (mapList != null && mapList.size() > 0) {
	                ExcelUtils.excelPrint(book, fileName, heads, fileds, mapList, widths, null);
	         }
	         this.export(book, fileName + System.currentTimeMillis() + ".xls");
		}catch (Throwable e) {
			e.printStackTrace();
			log.error("导出订单列表错误", e);
		}
	}
	
	/**
	 * 导入UI
	 */
	@RequestMapping("/importsUI")
	public ModelAndView importsUI(){
		modelAndView("order/orderImports");
		return modelAndView;
	}
	
	/**
	 * 导入
	 */
	@RequestMapping("/imports")
	public ModelAndView imports(@RequestParam("file") MultipartFile file){
		ResultCode resultCode=ResultCode.newSuccess();
		try {
			
			String excelFileName=file.getOriginalFilename();
			File excel=new File(getExcelFileUploadsBasedir(),excelFileName);
			file.transferTo(excel);
			List<List<String>> dataList = ExcelUtils.readExcel(excel, excelFileName, 2);
			if(dataList!=null&&!dataList.isEmpty()){
				OrderVo orderVo=null;
				for (List<String> row:dataList) {
					orderVo=new OrderVo();
					orderVo.setNo(row.get(0));
					orderVo.setArea(row.get(1));
					orderVo.setAddress(row.get(2));
					orderVo.setCustomerName(row.get(3));
					orderVo.setWeight(CommonUtils.parseInt(row.get(4)));
					orderVo.setPatient(row.get(5));
					orderVo.setOrderNo(row.get(6));
					orderVo.setPaymentUnit(row.get(7));
					orderVo.setReceiptTime(DateUtil.getDateByformatYMD(row.get(8)));
					orderVo.setShipmentTime(DateUtil.getDateByformatYMD(row.get(9)));
					orderVo.setEffectiveTime(DateUtil.getDateByformatYMD(row.get(10)));
					orderVo.setModel(row.get(11));
					orderVo.setSinglejaw(row.get(12));
					orderVo.setMaterial(row.get(13));
					orderVo.setPrice(CommonUtils.parseBigDecimal(row.get(14)));
					orderVo.setPaymentDesc(row.get(15));
					orderVo.setPaymentTime(DateUtil.getDateByformatYMD(row.get(16)));
					orderVo.setRemark(row.get(17));
					orderVo.seteBrace(row.get(18));
					orderVo.setFollowPerson(row.get(19));
					orderVo.setSalePerson(row.get(20));
					try{
						orderService.add(orderVo);
					}catch (Throwable e) {
						log.error("导入数据，保存数据异常,orderVo={},xxx异常信息={}",orderVo,e);
					}
				}
			}else{
				resultCode.setFail("解析无数据,请上传正确的Excel文件");
			}
			
		} catch (Throwable e) {
			log.error("导入数据异常", e);
			resultCode.setFail("导入数据异常");
		}
		getRequest().setAttribute("resultCode", resultCode);
		modelAndView("order/orderImports");
		return modelAndView;
	}
	
}
