/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dulieu;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.logging.Logger;

public class KhoiTaoCSDLHoaDon {
    private static final Logger LOG = Logger.getLogger(KhoiTaoCSDLHoaDon.class.getName());

    public static void main(String[] args) {
        try {
            String projectRoot = System.getProperty("user.dir");
            File xmlFile = new File(projectRoot + "HoaDon.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;
            Element root;

            if (xmlFile.exists()) {
                // Nạp file cũ, không ghi đè, chỉ thêm mới
                doc = builder.parse(xmlFile);
                root = doc.getDocumentElement();
                System.out.println("📄 File đã tồn tại, thêm dữ liệu mới vào: " + xmlFile.getAbsolutePath());
            } else {
                // Tạo mới
                doc = builder.newDocument();
                root = doc.createElement("DanhSachHoaDon");
                doc.appendChild(root);
                System.out.println("🆕 Tạo mới file XML: " + xmlFile.getAbsolutePath());
            }
            // THÊM HÓA ĐƠN
            addInvoice(doc, root, "HD001", "KH001", "G001", "2025-07-03", "2", "5000000");
            addInvoice(doc, root, "HD002", "KH002", "G002", "2025-07-03", "1", "1900000");
            addInvoice(doc, root, "HD003", "KH003", "G005", "2025-07-24", "3", "57000000");
            addInvoice(doc, root, "HD004", "KH004", "G012", "2025-08-25", "4", "7608000");
            addInvoice(doc, root, "HD005", "KH005", "G015", "2025-07-15", "2", "38000000");

            saveToFile(doc, xmlFile);
        } catch (Exception e) {
            System.err.println("❌ Lỗi xử lý XML hóa đơn:");
            e.printStackTrace();
        }
    }

    private static void addInvoice(Document doc, Element root, String maHD, String maKH, String maGiay,
                                   String ngayMua, String soLuong, String tongTien) {
        Element hoaDon = doc.createElement("HoaDon");
        appendChild(doc, hoaDon, "MaHD", maHD);
        appendChild(doc, hoaDon, "MaKH", maKH);
        appendChild(doc, hoaDon, "MaGiay", maGiay);
        appendChild(doc, hoaDon, "NgayMua", ngayMua);
        appendChild(doc, hoaDon, "SoLuong", soLuong);
        appendChild(doc, hoaDon, "TongTien", tongTien);
        root.appendChild(hoaDon);
    }

    private static void appendChild(Document doc, Element parent, String tag, String text) {
        Element e = doc.createElement(tag);
        e.appendChild(doc.createTextNode(text));
        parent.appendChild(e);
    }

    private static void saveToFile(Document doc, File file) throws TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(new DOMSource(doc), new StreamResult(file));
        System.out.println("✅ Dữ liệu đã được lưu vào: " + file.getAbsolutePath());
    }
}
