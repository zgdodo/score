package org.mission.ctcoms.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.mission.ctcoms.domain.Score;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: do
 * Date: 13-3-15
 * Time: 下午11:54
 * To change this template use File | Settings | File Templates.
 */
public class Exceltest<T> {
    Class<T> clazz;

    public Exceltest(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Collection<T> importExcel(File file, String... pattern) {
        Collection<T> dist = new ArrayList();
        try {
            /**
             * 类反射得到调用方法
             */
            // 得到目标目标类的所有的字段列表
            Field filed[] = clazz.getDeclaredFields();
            // 将所有标有Annotation的字段，也就是允许导入数据的字段,放入到一个map中
            Map fieldmap = new HashMap();
            // 循环读取所有字段
            for (int i = 0; i < filed.length; i++) {
                Field f = filed[i];
                // 得到单个字段上的Annotation
                ExcelAnnotation exa = f.getAnnotation(ExcelAnnotation.class);
                // 如果标识了Annotationd的话
                if (exa != null) {
                    // 构造设置了Annotation的字段的Setter方法
                    String fieldname = f.getName();
                    String setMethodName = "set"
                            + fieldname.substring(0, 1).toUpperCase()
                            + fieldname.substring(1);
                    // 构造调用的method，
                    Method setMethod = clazz.getMethod(setMethodName,
                            new Class[]{f.getType()});
                    // 将这个method以Annotaion的名字为key来存入。
                    fieldmap.put(exa.exportName(), setMethod);
                }
            }
            /**
             * excel的解析开始
             */
            // 将传入的File构造为FileInputStream;
            FileInputStream in = new FileInputStream(file);
            // // 得到工作表
            HSSFWorkbook book = new HSSFWorkbook(in);
            // // 得到第一页
            HSSFSheet sheet = book.getSheetAt(0);
            // // 得到第一面的所有行
            Iterator<Row> row = sheet.rowIterator();
            int rows = sheet.getPhysicalNumberOfRows(); // 获得行数

            /**
             * 标题解析
             */
            // 得到第一行，也就是标题行
            Row title = row.next();
            // 得到第一行的所有列
            Iterator<Cell> cellTitle = title.cellIterator();
            // 将标题的文字内容放入到一个map中。
            Map titlemap = new HashMap();
            // 从标题第一列开始
            int i = 0;
            // 循环标题所有的列
            while (cellTitle.hasNext()) {
                Cell cell = cellTitle.next();
                String value = cell.getStringCellValue();
                titlemap.put(i, value);
                i = i + 1;
            }
            /**
             * 解析内容行
             */
            //用来格式化日期的DateFormat
            SimpleDateFormat sf;
            if (pattern.length < 1) {
                sf = new SimpleDateFormat("yyyy-MM-dd");
            } else
                sf = new SimpleDateFormat(pattern[0]);
            if (rows > 0) {
//                while (row.hasNext()) {
                for (int j = 1; j < rows; j++) {     //行循环
                    // 标题下的第一行
//                    Row rown = row.next();
                    HSSFRow rown = sheet.getRow(j);
//                    Iterator<Cell> cellbody = rown.cellIterator();      // 行的所有列
                    int cells = rown.getLastCellNum();// 获得列数

                    // 得到传入类的实例
                    T tObject = clazz.newInstance();
//                    int k = 0;
                    // 遍历一行的列
//                    while (cellbody.hasNext()) {
                    for (int k = 0; k < cells; k++) {
                        HSSFCell cell =rown.getCell(k);
                        // 这里得到此列的对应的标题
                        String titleString = (String) titlemap.get(k);

                        // 如果这一列的标题和类中的某一列的Annotation相同，那么则调用此类的的set方法，进行设值
                        if (fieldmap.containsKey(titleString)) {
//                    判断类型并放入实体，excel的类型和实体类型都要匹配不然会出错，摊上事，摊上麻烦事
                            Method setMethod = (Method) fieldmap.get(titleString);
                            String value = "";
                            if (cell != null) {
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
                                            value = "non";
                                        }
                                        break;
                                    case HSSFCell.CELL_TYPE_BOOLEAN:// 布尔
                                        value = "" + cell.getBooleanCellValue();
                                        break;
                                    /* 此行表示该单元格值为空 */
                                    case HSSFCell.CELL_TYPE_BLANK: // 空值
                                        value = "0";
                                        break;
                                    case HSSFCell.CELL_TYPE_ERROR: // 故障
                                        value = "E";
                                        break;
                                    default:
                                        value = cell.getRichStringCellValue()
                                                .toString().trim();
                                }
                                setMethod.invoke(tObject, value);
                            } else
                                setMethod.invoke(tObject, "0");

                            //                        Method setMethod = (Method) fieldmap.get(titleString);
//                        //得到setter方法的参数
//                        Class<?>[] ts = setMethod.getParameterTypes();
//                        //只要一个参数
//                        Object xclass = ts[0];
//                        //判断参数类型
//                        if(xclass instanceof String)
//                        {
//                            setMethod.invoke(tObject, cell.getStringCellValue());
//                        }
//                        else if(xclass instanceof Date)
//                        {
//                            setMethod.invoke(tObject, sf.parse(cell.getStringCellValue()));
//                        }
//                        else if(xclass instanceof Integer)
//                        {
//                            setMethod.invoke(tObject,cell.getNumericCellValue() );
//                        }



                        }

                        // 下一列
//                        k = k + 1;
                    }
                    dist.add(tObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return dist;
    }

    public static void main(String[] args) {
        Exceltest<Score> test = new Exceltest(Score.class);
        File file = new File("d:/期末考试.xls");
        Long befor = System.currentTimeMillis();
        List<Score> result = (ArrayList) test.importExcel(file);

        Long after = System.currentTimeMillis();
        System.out.println("此次操作共耗时：" + (after - befor) + "毫秒");
        for (int i = 0; i < result.size(); i++) {
            Score loginfo = result.get(i);

            System.out.println("导入的信息为：" +
                    "a:" + loginfo.getExDes() +
                    ",b:" + loginfo.getExNumber() +
                    ",c:" + loginfo.getStuName() +
                    ",d:" + loginfo.getArts() +
                    ",e:" + loginfo.getBiology() +
                    ",f:" + loginfo.getChemistry() +
                    ",g:" + loginfo.getHistory() +
                    ",h:" + loginfo.getScience() +
                    ",i:" + loginfo.getPhysics() +
                    ",j:" + loginfo.getPolitics() +
                    ",k:" + loginfo.getClassRank());

            System.out.println("l------------->" + i);
        }

        System.out.println("共转化为List的行数为：" + result.size());
    }
}
