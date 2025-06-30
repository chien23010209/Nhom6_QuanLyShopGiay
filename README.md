🥿👟 Quản Lý Shop Giày - README
🧾 MÔ TẢ PHẦN MỀM
Phần mềm Quản lý Shop Giày là một ứng dụng quản lý bán hàng cho cửa hàng giày dép, giúp nhân viên và chủ cửa hàng quản lý hiệu quả các hoạt động như: nhập hàng, bán hàng, thống kê doanh thu, tìm kiếm sản phẩm theo mã hoặc tên, và hiển thị thông tin kèm hình ảnh sản phẩm.

Phần mềm được phát triển bằng ngôn ngữ Java trên công cụ NetBeans IDE, sử dụng XML làm cơ sở dữ liệu.

⚙️ CHỨC NĂNG CHÍNH
Đăng nhập hệ thống

Xác thực người dùng thông qua tài khoản đã được lưu trong file XML.

Sau khi đăng nhập thành công, người dùng có thể sử dụng các chức năng của hệ thống.

Nhập hàng

Nhập thông tin giày dép mới: mã sản phẩm, tên, size, màu sắc, giá nhập, số lượng, đường dẫn hình ảnh,...

Dữ liệu được lưu vào file XML.

Bán hàng

Ghi nhận giao dịch bán hàng: chọn sản phẩm, số lượng bán, tính tổng tiền.

Cập nhật tồn kho trong XML sau khi bán.

Thống kê

Thống kê số lượng sản phẩm đã bán, tồn kho, tổng doanh thu theo ngày, tuần hoặc tháng.

Tìm kiếm sản phẩm

Tìm kiếm theo mã sản phẩm, tên giày hoặc size.

Kết quả tìm kiếm hiển thị thông tin chi tiết cùng hình ảnh sản phẩm.

🔐 THÔNG TIN TÀI KHOẢN ĐĂNG NHẬP MẶC ĐỊNH
plaintext
Copy
Edit
Tài khoản: admin
Mật khẩu : 123456
Thông tin tài khoản được lưu trong file XML: users.xml

▶️ HƯỚNG DẪN CHẠY CHƯƠNG TRÌNH
Bước 1: Môi trường cần thiết
Cài đặt NetBeans IDE (khuyến nghị phiên bản 12 trở lên).

Java Development Kit (JDK) 8 trở lên.

Đảm bảo file XML (ví dụ: products.xml, users.xml, sales.xml) đã được tạo đúng định dạng.

Bước 2: Mở project
Mở NetBeans.

Chọn File > Open Project và chọn thư mục chứa mã nguồn bài tập lớn.

Bước 3: Chạy chương trình
Click chuột phải vào project và chọn Run hoặc nhấn F6.

Giao diện đăng nhập hiện ra → nhập thông tin tài khoản để đăng nhập.

Sau khi đăng nhập thành công, sử dụng các chức năng qua giao diện chính.

📂 CẤU TRÚC THƯ MỤC DỰ ÁN
plaintext
Copy
Edit
ShopGiay/
│
├── src/
│   ├── gui/                # Giao diện người dùng
│   ├── model/              # Lớp xử lý dữ liệu XML
│   ├── utils/              # Tiện ích xử lý XML
│   └── Main.java           # Điểm khởi chạy chính
│
├── data/
│   ├── products.xml        # Lưu thông tin sản phẩm
│   ├── users.xml           # Lưu tài khoản người dùng
│   └── sales.xml           # Lưu thông tin giao dịch bán hàng
│
└── README.md               # File hướng dẫn


## 👨‍💻 NHÓM THỰC HIỆN

- **Nhóm 4 – Lớp CNTT2**
- **Thành viên**:
Tạ Công Chiến	23010209
Phạm Bá Hiếu 	23010216
Nguyễn Hữu Nghĩa 	21012081
