import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.logging.Logger;

public class KhoiTaoCSDLGiay {
    private static final Logger LOG = Logger.getLogger(KhoiTaoCSDLGiay.class.getName());

    public static void main(String[] args) {
         try {
            String projectRoot = System.getProperty("user.dir");
            File xmlFile = new File(projectRoot + "Shoes.xml");

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
                root = doc.createElement("DanhSachGiay");
                doc.appendChild(root);
                System.out.println("🆕 Tạo mới file XML: " + xmlFile.getAbsolutePath());
            }

            addShoe(doc, root, "G001", "Nike Air Force 1", "Nike", "40", "Trắng", "2500000", "2025-07-01", "132", "images/R.jfif");
            addShoe(doc, root, "G002", "Adidas Stan Smith", "Adidas", "41", "Trắng/Xanh", "1900000", "2025-07-02", "50", "images/giaydidas.jpg");
            addShoe(doc, root, "G003", "gucci rython", "gucci", "39", "Vàng", "29000000", "2025-07-03", "150", "images/giayguccci.jpg");
            addShoe(doc, root, "G004", "Adidas Hồng", "Adidas", "40", "hồng/đen", "1000000", "2025-02-02", "500", "images/adidas.webp");
            addShoe(doc, root, "G005", "Giày tây", "Reman", "43", "Nâu", "19000000", "2025-07-05", "80", "images/giayda.jpg");
            addShoe(doc, root, "G006", "Nike AF1", "Nike", "39", "Hồng /xanh", "10900000", "2024-07-02", "60", "images/nikenu.jpg");
            addShoe(doc, root, "G007", "Gucci nam", "Gucci", "41", "Trắng", "29000000", "2025-07-02", "30", "images/Giay-Gucci-nam.jpg");
            addShoe(doc, root, "G008", "Guccist", "Gucci", "41", "Nâu", "19000000", "2025-04-02", "50", "images/guccist.jpg");
            addShoe(doc, root, "G009", "Gucci da", "Gucci", "41", "Nâu", "40000000", "2024-09-02", "50", "images/guccida.jpg");
            addShoe(doc, root, "G010", "Giày thể thao", "Din cox", "42", "Trắng", "900000", "2025-01-24", "150", "images/giaythethao.jpg");
            addShoe(doc, root, "G011", "Sport and CO", "Fila", "39", "Trắng", "950000", "2025-07-12", "90", "images/fila.jpg");
            addShoe(doc, root, "G012", "Nike Joden", "Nike", "41", "Trắng/Đen", "1902000", "2024-10-22", "70", "images/joden.jpg");
            addShoe(doc, root, "G013", "Adidas Stan", "Adidas", "38", "Trắng", "110000", "2025-03-02", "56", "images/fly.jfif");
            addShoe(doc, root, "G014", "Nike AIR", "Nike", "40", "Vàng", "9400000", "2025-01-02", "130", "images/OIP.webp");
            addShoe(doc, root, "G015", "gucci đỏ", "Gucci", "42", "đỏ", "19000000", "2025-06-02", "60", "images/guccido.jpg");

            saveToFile(doc, xmlFile);
        } catch (Exception e) {
            System.err.println("❌ Lỗi xử lý XML giày:");
            e.printStackTrace();
        }
    }

    private static void addShoe(Document doc, Element root, String ma, String ten, String hang, String size,
                                String mau, String gia, String ngayNhap, String soLuong, String hinhAnh) {
        Element giay = doc.createElement("Giay");
        appendChild(doc, giay, "MaGiay", ma);
        appendChild(doc, giay, "TenGiay", ten);
        appendChild(doc, giay, "Hang", hang);
        appendChild(doc, giay, "Size", size);
        appendChild(doc, giay, "MauSac", mau);
        appendChild(doc, giay, "Gia", gia);
        appendChild(doc, giay, "NgayNhap", ngayNhap);
        appendChild(doc, giay, "SoLuongTon", soLuong);
        appendChild(doc, giay, "HinhAnh", hinhAnh);
        root.appendChild(giay);
    }

    private static void appendChild(Document doc, Element parent, String tag, String text) {
        Element el = doc.createElement(tag);
        el.appendChild(doc.createTextNode(text));
        parent.appendChild(el);
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
