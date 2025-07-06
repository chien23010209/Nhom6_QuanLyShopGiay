package dulieu;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;

public class KhoiTaoDataKhachHang {

    public static void main(String[] args) {
       try {
            String projectRoot = System.getProperty("user.dir");
            File xmlFile = new File(projectRoot + "KhacHang.xml");

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

            addCustomerWithInvoices(doc, root, "KH001", "Nguyễn Văn Siu", "0355556666", "Hà Nội",
                    new String[][]{
                            {"HD001", "G001", "2025-07-03", "2", "5000000"}
                    });

            addCustomerWithInvoices(doc, root, "KH002", "Trần Thị Hoan", "0988889999", "TP.HCM",
                    new String[][]{
                            {"HD002", "G002", "2025-07-03", "1", "1900000"}
                    });

            addCustomerWithInvoices(doc, root, "KH003", "Lê Văn Dân", "0911223344", "Đà Nẵng",
                    new String[][]{
                            {"HD003", "G005", "2025-07-24", "3", "57000000"}
                    });

            addCustomerWithInvoices(doc, root, "KH004", "Lê Khắc Chân", "0916437328", "Lạng Sơn",
                    new String[][]{
                            {"HD004", "G012", "2025-08-25", "4", "7608000"}
                    });

            addCustomerWithInvoices(doc, root, "KH005", "Tạ Khánh Chi", "0911342233", "Hưng Yên",
                    new String[][]{
                            {"HD005", "G015", "2025-07-15", "2", "38000000"}
                    });

            saveToFile(doc, xmlFile);
        } catch (Exception e) {
            System.err.println("❌ Lỗi xử lý XML:");
            e.printStackTrace();
        }
    }

    private static void addCustomerWithInvoices(Document doc, Element root,
                                                String maKH, String tenKH, String sdt, String diaChi,
                                                String[][] hoaDonList) {
        Element khach = doc.createElement("KhachHang");

        appendChild(doc, khach, "MaKH", maKH);
        appendChild(doc, khach, "TenKH", tenKH);
        appendChild(doc, khach, "SDT", sdt);
        appendChild(doc, khach, "DiaChi", diaChi);

        Element danhSachHD = doc.createElement("DanhSachMuaHang");
        for (String[] hd : hoaDonList) {
            Element hoaDon = doc.createElement("HoaDon");
            appendChild(doc, hoaDon, "MaHD", hd[0]);
            appendChild(doc, hoaDon, "MaGiay", hd[1]);
            appendChild(doc, hoaDon, "NgayMua", hd[2]);
            appendChild(doc, hoaDon, "SoLuong", hd[3]);
            appendChild(doc, hoaDon, "TongTien", hd[4]);
            danhSachHD.appendChild(hoaDon);
        }

        khach.appendChild(danhSachHD);
        root.appendChild(khach);
    }

    private static void appendChild(Document doc, Element parent, String tag, String text) {
        Element element = doc.createElement(tag);
        element.appendChild(doc.createTextNode(text));
        parent.appendChild(element);
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
