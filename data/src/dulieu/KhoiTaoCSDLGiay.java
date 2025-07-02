import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.logging.Logger;

public class KhoiTaoCSDLGiay {
    public static void main(String[] args) {
         try {
           
            String projectRoot = System.getProperty("user.dir");
            File xmlFile = new File(projectRoot + "shoes.xml");

            if (xmlFile.exists()) {
                System.out.println("❗ File đã tồn tại tại: " + xmlFile.getAbsolutePath());
                return;
            }
          
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // Gốc <DanhSachGiay>
            Element root = doc.createElement("DanhSachGiay");
            doc.appendChild(root);

            // ===== Giày mẫu 1 =====
            Element giay1 = doc.createElement("Giay");
            appendChild(doc, giay1, "MaGiay", "G001");
            appendChild(doc, giay1, "TenGiay", "Nike Air Force 1");
            appendChild(doc, giay1, "Hang", "Nike");
            appendChild(doc, giay1, "Size", "40");
            appendChild(doc, giay1, "MauSac", "Trắng");
            appendChild(doc, giay1, "Gia", "2500000");
            appendChild(doc, giay1, "NgayNhap", "2025-07-01");
            appendChild(doc, giay1, "SoLuongTon", "132");
            appendChild(doc, giay1, "HinhAnh", "images/R.jfif");
            root.appendChild(giay1);

            // ===== Giày mẫu 2 =====
            Element giay2 = doc.createElement("Giay");
            appendChild(doc, giay2, "MaGiay", "G002");
            appendChild(doc, giay2, "TenGiay", "Adidas Stan Smith");
            appendChild(doc, giay2, "Hang", "Adidas");
            appendChild(doc, giay2, "Size", "41");
            appendChild(doc, giay2, "MauSac", "Trắng/Xanh");
            appendChild(doc, giay2, "Gia", "1900000");
            appendChild(doc, giay2, "NgayNhap", "2025-07-02");
            appendChild(doc, giay2, "SoLuongTon", "50");
            appendChild(doc, giay2, "HinhAnh", "images/giaydidas.jpg");
            root.appendChild(giay2);
            // ===== Giày mẫu 3 =====
            Element giay3 = doc.createElement("Giay");
            appendChild(doc, giay3, "MaGiay", "G003");
            appendChild(doc, giay3, "TenGiay", "gucci rython");
            appendChild(doc, giay3, "Hang", "gucci");
            appendChild(doc, giay3, "Size", "39");
            appendChild(doc, giay3, "MauSac", "Vàng");
            appendChild(doc, giay3, "Gia", "29000000");
            appendChild(doc, giay3, "NgayNhap", "2025-07-03");
            appendChild(doc, giay3, "SoLuongTon", "150");
            appendChild(doc, giay3, "HinhAnh", "images/giayguccci.jpg");
            root.appendChild(giay3);
            // ===== Giày mẫu 4 =====
            Element giay4 = doc.createElement("Giay");
            appendChild(doc, giay4, "MaGiay", "G004");
            appendChild(doc, giay4, "TenGiay", "Adidas Hồng");
            appendChild(doc, giay4, "Hang", "Adidas");
            appendChild(doc, giay4, "Size", "40");
            appendChild(doc, giay4, "MauSac", "hồng/đen");
            appendChild(doc, giay4, "Gia", "1000000");
            appendChild(doc, giay4, "NgayNhap", "2025-02-02");
            appendChild(doc, giay4, "SoLuongTon", "500");
            appendChild(doc, giay4, "HinhAnh", "images/adidas.webp");
            root.appendChild(giay4);
            // ===== Giày mẫu 5 =====
             Element giay5 = doc.createElement("Giay");
            appendChild(doc, giay5, "MaGiay", "G005");
            appendChild(doc, giay5, "TenGiay", "Giày tây ");
            appendChild(doc, giay5, "Hang", "Reman");
            appendChild(doc, giay5, "Size", "43");
            appendChild(doc, giay5, "MauSac", "Nâu");
            appendChild(doc, giay5, "Gia", "19000000");
            appendChild(doc, giay5, "NgayNhap", "2025-07-05");
            appendChild(doc, giay5, "SoLuongTon", "80");
            appendChild(doc, giay5, "HinhAnh", "images/giayda.jpg");
            root.appendChild(giay5);
            // ===== Giày mẫu 6=====
            Element giay6 = doc.createElement("Giay");
            appendChild(doc, giay6, "MaGiay", "G006");
            appendChild(doc, giay6, "TenGiay", "Nike AF1");
            appendChild(doc, giay6, "Hang", "Nike");
            appendChild(doc, giay6, "Size", "39");
            appendChild(doc, giay6, "MauSac", "Hồng /xanh");
            appendChild(doc, giay6, "Gia", "10900000");
            appendChild(doc, giay6, "NgayNhap", "2024-07-02");
            appendChild(doc, giay6, "SoLuongTon", "60");
            appendChild(doc, giay6, "HinhAnh", "images/nikenu.jpg");
            root.appendChild(giay6);
            // ===== Giày mẫu 7 =====
            Element giay7 = doc.createElement("Giay");
            appendChild(doc, giay7, "MaGiay", "G007");
            appendChild(doc, giay7, "TenGiay", "Gucci nam");
            appendChild(doc, giay7, "Hang", "Gucci");
            appendChild(doc, giay7, "Size", "41");
            appendChild(doc, giay7, "MauSac", "Trắng");
            appendChild(doc, giay7, "Gia", "29000000");
            appendChild(doc, giay7, "NgayNhap", "2025-07-02");
            appendChild(doc, giay7, "SoLuongTon", "30");
            appendChild(doc, giay7, "HinhAnh", "images/Giay-Gucci-nam.jpg");
            root.appendChild(giay7);
            // ===== Giày mẫu 8 =====
            Element giay8 = doc.createElement("Giay");
            appendChild(doc, giay8, "MaGiay", "G008");
            appendChild(doc, giay8, "TenGiay", "Guccist");
            appendChild(doc, giay8, "Hang", "Gucci");
            appendChild(doc, giay8, "Size", "41");
            appendChild(doc, giay8, "MauSac", "Nâu");
            appendChild(doc, giay8, "Gia", "19000000");
            appendChild(doc, giay8, "NgayNhap", "2025-04-02");
            appendChild(doc, giay8, "SoLuongTon", "50");
            appendChild(doc, giay8, "HinhAnh", "images/guccist.jpg");
            root.appendChild(giay8);
            // ===== Giày mẫu 9 =====
            Element giay9 = doc.createElement("Giay");
            appendChild(doc, giay9, "MaGiay", "G009");
            appendChild(doc, giay9, "TenGiay", "Gucci da");
            appendChild(doc, giay9, "Hang", "Gucci");
            appendChild(doc, giay9, "Size", "41");
            appendChild(doc, giay9, "MauSac", "Nâu");
            appendChild(doc, giay9, "Gia", "40000000");
            appendChild(doc, giay9, "NgayNhap", "2024-09-02");
            appendChild(doc, giay9, "SoLuongTon", "50");
            appendChild(doc, giay9, "HinhAnh", "images/guccida.jpg");
            root.appendChild(giay9);
            // ===== Giày mẫu 10 =====
            Element giay10 = doc.createElement("Giay");
            appendChild(doc, giay10, "MaGiay", "G010");
            appendChild(doc, giay10, "TenGiay", "Giày thể thao ");
            appendChild(doc, giay10, "Hang", "Din cox");
            appendChild(doc, giay10, "Size", "42");
            appendChild(doc, giay10, "MauSac", "Trắng");
            appendChild(doc, giay10, "Gia", "900000");
            appendChild(doc, giay10, "NgayNhap", "2025-01-24");
            appendChild(doc, giay10, "SoLuongTon", "150");
            appendChild(doc, giay10, "HinhAnh", "images/giaythethao.jpg");
            root.appendChild(giay10);
            // ===== Giày mẫu 11 =====
            Element giay11 = doc.createElement("Giay");
            appendChild(doc, giay11, "MaGiay", "G011");
            appendChild(doc, giay11, "TenGiay", "Sport and CO");
            appendChild(doc, giay11, "Hang", "Fila");
            appendChild(doc, giay11, "Size", "39");
            appendChild(doc, giay11, "MauSac", "Trắng");
            appendChild(doc, giay11, "Gia", "950000");
            appendChild(doc, giay11, "NgayNhap", "2025-07-12");
            appendChild(doc, giay11, "SoLuongTon", "90");
            appendChild(doc, giay11, "HinhAnh", "images/fila.jpg");
            root.appendChild(giay11);
            // ===== Giày mẫu 12 =====
            Element giay12 = doc.createElement("Giay");
            appendChild(doc, giay12, "MaGiay", "G012");
            appendChild(doc, giay12, "TenGiay", "Nike Joden");
            appendChild(doc, giay12, "Hang", "Nike");
            appendChild(doc, giay12, "Size", "41");
            appendChild(doc, giay12, "MauSac", "Trắng/Đen");
            appendChild(doc, giay12, "Gia", "1902000");
            appendChild(doc, giay12, "NgayNhap", "2024-10-22");
            appendChild(doc, giay12, "SoLuongTon", "70");
            appendChild(doc, giay12, "HinhAnh", "images/joden.jpg");
            root.appendChild(giay12);
            // ===== Giày mẫu 13 =====
            Element giay13 = doc.createElement("Giay");
            appendChild(doc, giay13, "MaGiay", "G013");
            appendChild(doc, giay13, "TenGiay", "Adidas Stan ");
            appendChild(doc, giay13, "Hang", "Adidas");
            appendChild(doc, giay13, "Size", "38");
            appendChild(doc, giay13, "MauSac", "Trắng");
            appendChild(doc, giay13, "Gia", "110000");
            appendChild(doc, giay13, "NgayNhap", "2025-03-02");
            appendChild(doc, giay13, "SoLuongTon", "56");
            appendChild(doc, giay13, "HinhAnh", "images/fly.jfif");
            root.appendChild(giay13);
            // ===== Giày mẫu 14 =====
            Element giay14 = doc.createElement("Giay");
            appendChild(doc, giay14, "MaGiay", "G014");
            appendChild(doc, giay14, "TenGiay", "Nike AIR");
            appendChild(doc, giay14, "Hang", "Nike");
            appendChild(doc, giay14, "Size", "40");
            appendChild(doc, giay14, "MauSac", "Vàng");
            appendChild(doc, giay14, "Gia", "9400000");
            appendChild(doc, giay14, "NgayNhap", "2025-01-02");
            appendChild(doc, giay14, "SoLuongTon", "130");
            appendChild(doc, giay14, "HinhAnh", "images/OIP.webp");
            root.appendChild(giay14);
            // ===== Giày mẫu 15 =====
            Element giay15 = doc.createElement("Giay");
            appendChild(doc, giay15, "MaGiay", "G015");
            appendChild(doc, giay15, "TenGiay", "gucci đỏ");
            appendChild(doc, giay15, "Hang", "Gucci");
            appendChild(doc, giay15, "Size", "42");
            appendChild(doc, giay15, "MauSac", "đỏ");
            appendChild(doc, giay15, "Gia", "19000000");
            appendChild(doc, giay15, "NgayNhap", "2025-06-02");
            appendChild(doc, giay15, "SoLuongTon", "60");
            appendChild(doc, giay15, "HinhAnh", "images/guccido.jpg");
            root.appendChild(giay15);

            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");  
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);

            System.out.println("✅ Đã tạo file Giay.xml với dữ liệu mẫu tại: " + xmlFile.getAbsolutePath());

        } catch (ParserConfigurationException | TransformerException e) {
            System.err.println("❌ Lỗi ghi XML:");
            e.printStackTrace();
        }
    }
    private static final Logger LOG = Logger.getLogger(KhoiTaoCSDLGiay.class.getName());
    private static void appendChild(Document doc, Element parent, String tagName, String textContent) {
        Element el = doc.createElement(tagName);
        el.appendChild(doc.createTextNode(textContent));
        parent.appendChild(el);
    }
}
