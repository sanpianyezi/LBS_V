package com.lbs.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletResponse;

import com.lbs.model.SiteInfo;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExportExcel {

	/**
	 * 
	 * @param response 响应 用于输出流返回
	 * @param excelNameArray 表头名称数组
	 * @param objIn
	 * @param objOut
	 */
public static void exportExcel(HttpServletResponse response, String[] excelNameArray ,List<SiteInfo> objList) {
         try {
         //取得response HttpServletResponse
//         HashMap hmOut = (HashMap)objOut;
//         HashMap hmIn = (HashMap)objIn;
//         HttpServletResponse response=(HttpServletResponse)hmIn.get("response");
         //设置table列名
//         String excelName =(String)hmIn.get("excelName");
//         String[] excelNameArray = excelName.split(",");
         
         
         //取得key
//         String[] excelKeyArray = (String[])hmOut.get("excelKey");
         
         OutputStream os = response.getOutputStream();// 取得输出流   
             response.reset();// 清空输出流  

             response.setHeader("Content-disposition", "attachment; filename="+new String("导出站点信息表".getBytes("GB2312"),"8859_1")+".xls");// 设定输出文件头   
             response.setContentType("application/msexcel");// 定义输出类型 
             
             WritableWorkbook wwb = Workbook.createWorkbook(os); // 建立excel文件   
         
             WritableSheet ws = wwb.createSheet("Sheet1", 10);        // 创建一个工作表

             //    设置单元格的文字格式
             WritableFont wf = new WritableFont(WritableFont.ARIAL,10,WritableFont.NO_BOLD,false,
                     UnderlineStyle.NO_UNDERLINE,Colour.BLUE);
             WritableCellFormat wcf = new WritableCellFormat(wf);
             wcf.setVerticalAlignment(VerticalAlignment.CENTRE); 
             wcf.setAlignment(Alignment.CENTRE); 
             ws.setRowView(0, 500);

             //    填充数据的内容
//             int len=((String[])hmOut.get(excelKeyArray[0])).length;
//             int len=objList.size();
             //设置列头名
         for (int j=0;j<excelNameArray.length;j++){
            ws.addCell(new Label(j, 0, excelNameArray[j], wcf));
         }
         //设置内容
         wcf = new WritableCellFormat();
             for (int i = 0; i <objList.size(); i++){
//             for (int j=0;j<excelNameArray.length;j++){
//                ws.addCell(new Label(j, i+1, ((String[])hmOut.get(excelKeyArray[j]))[i], wcf));
//             }
            	 
            	 SiteInfo siteInfo = objList.get(i); 	 
            	 ws.addCell(new Label(0, i+1, siteInfo.getSiteCode()==null?"":String.valueOf(siteInfo.getSiteCode()), wcf)); //站点编号
            	 ws.addCell(new Label(1, i+1, siteInfo.getSiteType(), wcf)); //站点类别
            	 ws.addCell(new Label(2, i+1, siteInfo.getSiteName(), wcf)); //站点名称
            	 ws.addCell(new Label(3, i+1, siteInfo.getServiceGroup(), wcf)); //维护班组
            	 ws.addCell(new Label(4, i+1, siteInfo.getVoltageGrade(), wcf)); //电压等级
            	 ws.addCell(new Label(5, i+1, siteInfo.getWorkTime(), wcf)); //投产日期
            	 ws.addCell(new Label(6, i+1, siteInfo.getIsIntelligent(), wcf)); //是否智能变电站
            	 ws.addCell(new Label(7, i+1, siteInfo.getIsHub(), wcf)); //是否枢纽站
            	 ws.addCell(new Label(8, i+1, siteInfo.getSiteLevel(), wcf)); //变电站重要等级
            	 ws.addCell(new Label(9, i+1, siteInfo.getDutyType(), wcf)); //值班方式
            	 ws.addCell(new Label(10, i+1, siteInfo.getAgentService(), wcf)); //是否代修
            	 ws.addCell(new Label(11, i+1, siteInfo.getCablingType(), wcf)); //布置方式
            	 ws.addCell(new Label(12, i+1, siteInfo.getContaminationLevel(), wcf)); //污秽等级
            	 ws.addCell(new Label(13, i+1, siteInfo.getSiteAddr(), wcf)); //站址
            	 ws.addCell(new Label(14, i+1, siteInfo.getAreaCovered()==null?"":String.valueOf(siteInfo.getAreaCovered()), wcf)); //占地面积(m2)
            	 ws.addCell(new Label(15, i+1, siteInfo.getBuildingArea()==null?"":String.valueOf(siteInfo.getBuildingArea()), wcf)); //建筑面积(m2)
            	 ws.addCell(new Label(16, i+1, siteInfo.getRegionFeatures(), wcf)); //地区特称
            	 ws.addCell(new Label(17, i+1, siteInfo.getContactTel(), wcf)); //联系电话
            	 ws.addCell(new Label(18, i+1, siteInfo.getShortName(), wcf)); //变电站简称
            	 ws.addCell(new Label(19, i+1, siteInfo.getEquipmentOwner(), wcf)); //设备主人
            	 
            	 ws.addCell(new Label(20, i+1, siteInfo.getRemark(), wcf)); //备注
            	 ws.addCell(new Label(21, i+1, siteInfo.getTotalCapacity()==null?"":String.valueOf(siteInfo.getTotalCapacity()), wcf)); //配变总容量(KVA)
            	 ws.addCell(new Label(22, i+1, siteInfo.getEquipmentNum()==null?"":String.valueOf(siteInfo.getEquipmentNum()), wcf)); //配变台数
            	 ws.addCell(new Label(23, i+1, siteInfo.getCablingType(), wcf)); //重要程度
            	 ws.addCell(new Label(24, i+1, siteInfo.getIsUnderground(), wcf)); //是否地下站
            	 ws.addCell(new Label(25, i+1, siteInfo.getIsIndependent(), wcf)); //是否独立建筑物
            	 ws.addCell(new Label(26, i+1, siteInfo.getPreventionType(), wcf)); //防误方式
            	 ws.addCell(new Label(27, i+1, siteInfo.getHasRingNetwork(), wcf)); //是否具有环网
            	 ws.addCell(new Label(28, i+1, siteInfo.getCompensateCapacity()==null?"":String.valueOf(siteInfo.getCompensateCapacity()), wcf)); //无功补偿容量(kVar)
            	 ws.addCell(new Label(29, i+1, siteInfo.getEquipmentCode(), wcf)); //设备类型编码
            	 ws.addCell(new Label(30, i+1, siteInfo.getLongitudePoint()==null?"":String.valueOf(siteInfo.getLongitudePoint()), wcf)); //经度
            	 ws.addCell(new Label(31, i+1, siteInfo.getLatitudePoint()==null?"":String.valueOf(siteInfo.getLatitudePoint()), wcf)); //纬度
            	 ws.addCell(new Label(32, i+1, siteInfo.getBelongArea(), wcf)); //纬度
            	 
            	 
            	 
            	 
            	 
            	 
            	 
             }

             wwb.write();
             wwb.close();

         } catch (IOException e){
         } catch (RowsExceededException e){
         } catch (WriteException e){}
     }

}