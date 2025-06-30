# 🥿 PHẦN MỀM QUẢN LÝ SHOP GIÀY – JAVA SWING + XML

## 📝 GIỚI THIỆU

Phần mềm **Quản lý shop giày** được xây dựng bằng **Java SE** sử dụng **giao diện Swing** và **lưu trữ dữ liệu bằng file XML**, không sử dụng hệ quản trị cơ sở dữ liệu (MySQL, SQLite...).

Phần mềm hỗ trợ quản lý sản phẩm, khách hàng, đơn hàng và đăng nhập nhân viên với phân quyền. Đây là ứng dụng dạng desktop phù hợp cho mục đích học tập và mô phỏng quản lý bán hàng.

---

## ⚙️ CẤU HÌNH PHÁT TRIỂN

- **Ngôn ngữ**: Java SE 23
- **Công cụ IDE**: Apache NetBeans 23
- **Hệ điều hành**: Windows / Linux / macOS
- **Thư viện**: Java Core (không dùng thư viện ngoài)

---

## 🔐 THÔNG TIN ĐĂNG NHẬP

Hệ thống yêu cầu đăng nhập trước khi sử dụng. Dưới đây là các tài khoản có sẵn:

| Tên đăng nhập | Mật khẩu   | Quyền truy cập   |
|---------------|------------|------------------|
| `admin`       | `admin123` | Quản trị viên    |
| `nhanvien1`   | `123456`   | Nhân viên bán hàng |

> 📁 Dữ liệu tài khoản lưu tại: `data/nhanvien.xml`

---

## 📋 CHỨC NĂNG CHÍNH

### 1. Đăng nhập hệ thống
- Giao diện đăng nhập đơn giản
- Phân quyền: admin và nhân viên

### 2. Quản lý sản phẩm
- Thêm, sửa, xoá sản phẩm
- Lưu tại `data/sanpham.xml`

### 3. Quản lý khách hàng
- Thêm khách hàng mới
- Lưu tại `data/khachhang.xml`

### 4. Quản lý đơn hàng
- Tạo đơn hàng, tính tổng tiền
- Lưu tại `data/donhang.xml`

### 5. Quản lý nhân viên (chỉ admin)
- Thêm, sửa, xoá tài khoản
- Lưu tại `data/nhanvien.xml`

---

## 🚀 HƯỚNG DẪN CHẠY CHƯƠNG TRÌNH

1. **Mở dự án bằng NetBeans 23**:
   - Vào `File` → `Open Project` → chọn thư mục `ShopGiay_XML`

2. **Chạy chương trình**:
   - Nhấn chuột phải vào `Main.java` → Chọn `Run File`
   - Hoặc nhấn `Shift + F6`

3. **Lưu ý**:
   - Lần đầu chạy, các file `.xml` sẽ được tạo tự động nếu chưa có

---

## 📂 CẤU TRÚC THƯ MỤC DỰ ÁN

ShopGiay_XML/
├── src/
│ ├── model/ # Lớp đối tượng: SanPham, DonHang, ...
│ ├── data/ # Đọc/ghi XML: XMLReader.java, XMLWriter.java
│ ├── ui/ # Giao diện người dùng (Swing)
│ └── Main.java # Điểm khởi chạy chương trình
├── data/
│ ├── sanpham.xml
│ ├── khachhang.xml
│ ├── donhang.xml
│ └── nhanvien.xml
├── README.md
└── BaoCao_BaiTapLon.pdf

yaml
Copy
Edit

---

## 👨‍💻 NHÓM THỰC HIỆN

- **Nhóm 4 – Lớp CNTT2**
- **Thành viên**:
  - Nguyễn Văn A – MSSV: 12345678
  - Trần Thị B – MSSV: 23456789
  - Lê Văn C – MSSV: 34567890
