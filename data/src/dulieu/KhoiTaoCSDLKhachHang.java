import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.logging.Logger;

public class KhoiTaoCSDLKhachHang {
    private static final Logger LOG = Logger.getLogger(KhoiTaoCSDLKhachHang.class.getName());

    public static void main(String[] args) {
         try {
            String projectRoot = System.getProperty("user.dir");
            File xmlFile = new File(projectRoot + "KhachHang.xml");

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
                root = doc.createElement("DanhSachKhachHang");
                doc.appendChild(root);
                System.out.println("🆕 Tạo mới file XML: " + xmlFile.getAbsolutePath());
            }
            // THÊM KHÁCH HÀNG MỚI
            addCustomer(doc, root, "KH001", "Nguyễn Văn Siu", "0355556666", "Hà Nội");
            addCustomer(doc, root, "KH002", "Trần Thị Hoan", "0988889999", "TP.HCM");
            addCustomer(doc, root, "KH003", "Lê Văn Dân", "0911223344", "Đà Nẵng");
            addCustomer(doc, root, "KH004", "Lê Khắc Chân", "0916437328", "Lạng Sơn");
            addCustomer(doc, root, "KH005", "Tạ Khánh Chi", "0911342233", "Hưng Yên");

            saveToFile(doc, xmlFile);
        } catch (Exception e) {
            System.err.println("❌ Lỗi xử lý XML khách hàng:");
            e.printStackTrace();
        }
    }

    private static void addCustomer(Document doc, Element root, String id, String name, String phone, String address) {
        Element khach = doc.createElement("KhachHang");
        appendChild(doc, khach, "MaKH", id);
        appendChild(doc, khach, "TenKH", name);
        appendChild(doc, khach, "SDT", phone);
        appendChild(doc, khach, "DiaChi", address);
        root.appendChild(khach);
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
