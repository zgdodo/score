package org.mission.ctcoms.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-3-6
 * Time: 上午12:32
 * To change this template use File | Settings | File Templates.
 */
public class ExcelCommon {
    /***
     *
     * @param in   POIFSFileSystem
     * @param max  所导入excel的列数
     * @return map
     * @throws IOException
     */
    public static Map<Integer, Map<Integer, List<String>>> getExcel(POIFSFileSystem in,int max)
            throws IOException {
        Map<Integer, Map<Integer, List<String>>> map = new HashMap<Integer, Map<Integer, List<String>>>();// 总map
        Map<Integer, List<String>> sheetMap = null;// 每个sheet的map
        List<String> list = null;// 每行一个list
        HSSFWorkbook workBook = null;
        try {
            workBook = new HSSFWorkbook(in);
        } catch (final Exception e) {
            throw new IOException("读取上传文件失败");
        }
        /**
         * 获得Excel中工作表个数
         */
        // sheet.autoSizeColumn(( short ) 0 );//导出自动适应宽度
        int sheetSize = workBook.getNumberOfSheets();
        //      System.out.println("工作表个数 :" + sheetSize);
        for (int i = 0; i < sheetSize; i++) {
            sheetMap = new HashMap<Integer, List<String>>();
            //          System.out.println("工作表名称:" + workBook.getSheetName(i));
            HSSFSheet sheet = workBook.getSheetAt(i);
            int rows = sheet.getPhysicalNumberOfRows(); // 获得行数
            if (rows > 0) {
                for (int j = 0; j < rows; j++) { // 行循环
                    list = new ArrayList<String>();
                    HSSFRow row = sheet.getRow(j);
                    if (row != null) {
                        int cells = row.getLastCellNum();// 获得列数
                        if(cells<max){
                            cells = max;
                        }
                        for (short k = 0; k < cells; k++) { // 列循环
                            HSSFCell cell = row.getCell(k);
                            String value = "";
                            if(cell != null){
                                switch (cell.getCellType()) {
                                    case HSSFCell.CELL_TYPE_NUMERIC: // 数值型
                                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                                            // 如果是date类型则 ，获取该cell的date值
                                            value = HSSFDateUtil.getJavaDate(
                                                    cell.getNumericCellValue())
                                                    .toString();
                                        } else {// 纯数字
                                            value = String.valueOf(cell
                                                    .getNumericCellValue());
                                        }
//                                        if(value.matches("^((\\d+\\.?\\d+)[Ee]{1}(\\d+)){1}quot;)){
//                                            DecimalFormat df = new DecimalFormat("#.##");
//                                        value = df.format(Double.parseDouble(value));
//                                }
                                break;
                                case HSSFCell.CELL_TYPE_STRING: // 字符串型
                                    value = cell.getRichStringCellValue()
                                            .toString().trim();
                                    break;
                                case HSSFCell.CELL_TYPE_FORMULA:// 公式型
                                    // 读公式计算值
                                    value = String.valueOf(cell
                                            .getNumericCellValue());
                                    if (value.equals("NaN")) {// 如果获取的数据值为非法值,则转换为获取字符串
                                        value = cell.getRichStringCellValue()
                                                .toString();
                                    }
                                    break;
                                case HSSFCell.CELL_TYPE_BOOLEAN:// 布尔
                                    value = "" + cell.getBooleanCellValue();
                                    break;
                                    /* 此行表示该单元格值为空 */
                                case HSSFCell.CELL_TYPE_BLANK: // 空值
                                    value = "";
                                    break;
                                case HSSFCell.CELL_TYPE_ERROR: // 故障
                                    value = "";
                                    break;
                                default:
                                    value = cell.getRichStringCellValue()
                                            .toString().trim();
                            }
                        }
                        list.add(value);
                    }
                    if(!isAllNull(list)){
                        sheetMap.put(j, list);
                    }
                }
            }
        }
        map.put(i, sheetMap);
    }
    return map;
}
    /**
     * 如果list里面的值全为空 则范围true 反之则为false
     * @param l list
     * @return
     */
    private static boolean isAllNull(List<String> l){
        int i=0;
        for(String s : l){
            if(!"".equals(s)){
                i++;
            }
        }
        if(i>0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String filePath = "d:/期末考试.xls";
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filePath));
            Map<Integer, Map<Integer, List<String>>> map = getExcel(fs,1);
            for(Map.Entry<Integer, List<String>> ent : map.get(0).entrySet()){
                System.out.println(ent);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
