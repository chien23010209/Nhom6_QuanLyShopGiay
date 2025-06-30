# 👟🥿 Quản Lý Shop Giày - README

---

## 📋 1. Mô tả phần mềm

Phần mềm **Quản lý Shop Giày** là ứng dụng hỗ trợ quản lý hoạt động kinh doanh của cửa hàng giày dép. Phần mềm được phát triển trên nền tảng **Java** sử dụng **NetBeans IDE** và lưu trữ dữ liệu bằng **file XML**. 

Ứng dụng cho phép người dùng thực hiện các chức năng cơ bản như:
- 🆕 Nhập hàng (thêm mới hoặc cập nhật sản phẩm giày dép)
- 🛒 Bán hàng (ghi nhận và quản lý đơn hàng)
- 📊 Thống kê doanh thu, số lượng tồn kho theo thời gian
- 🔍 Tìm kiếm sản phẩm theo mã, tên, size kèm hiển thị hình ảnh

Giao diện đơn giản, thân thiện giúp nhân viên và quản lý dễ dàng sử dụng, nâng cao hiệu quả bán hàng.

---

## ⚙️ 2. Chức năng chính

### 🔐 2.1 Đăng nhập hệ thống
- Người dùng cần đăng nhập với tài khoản hợp lệ mới có thể truy cập các chức năng.
- Tài khoản và mật khẩu được lưu trong file `users.xml`.
- Hệ thống có tài khoản mặc định:
  - 👤 Tài khoản: `admin`
  - 🔑 Mật khẩu: `123456`

### 🏷️ 2.2 Nhập hàng
- Thêm mới hoặc cập nhật sản phẩm giày dép với các thông tin:
  - 🆔 Mã sản phẩm, tên sản phẩm, size, màu sắc
  - 💰 Giá nhập, số lượng tồn kho
  - 🖼️ Đường dẫn hình ảnh (ảnh giày được lưu trong thư mục `images/`)
- Dữ liệu được ghi trực tiếp vào file `products.xml`.

### 🛍️ 2.3 Bán hàng
- Lựa chọn sản phẩm và số lượng để tạo đơn hàng bán.
- Tính tổng tiền và cập nhật tồn kho sau mỗi giao dịch.
- Giao dịch bán hàng được lưu lại trong `sales.xml`.

### 📈 2.4 Thống kê
- Thống kê tổng số sản phẩm đã bán, số lượng tồn kho còn lại.
- Thống kê doanh thu theo ngày, tuần hoặc tháng.
- Hiển thị kết quả thống kê theo bảng biểu dễ quan sát.

### 🔎 2.5 Tìm kiếm sản phẩm
- Tìm kiếm sản phẩm theo:
  - 🆔 Mã sản phẩm
  - 🏷️ Tên sản phẩm
  - 📏 Size giày
- Kết quả tìm kiếm trả về đầy đủ thông tin sản phẩm cùng hình ảnh minh họa.

---

## 🔐 3. Thông tin tài khoản đăng nhập mặc định

| 👤 Tài khoản | 🔑 Mật khẩu |
|-------------|------------|
| admin       | 123456     |

- Các tài khoản được lưu trong file `users.xml`.
- Người dùng có thể mở và chỉnh sửa file XML này để thêm hoặc thay đổi tài khoản.

---

## 🚀 4. Hướng dẫn cài đặt và chạy chương trình

### 🛠️ 4.1 Yêu cầu môi trường
- Cài đặt **Java JDK** phiên bản 23.
- Cài đặt **NetBeans IDE** (phiên bản 21 trở lên khuyến nghị).
- Đảm bảo có các file dữ liệu XML chuẩn:
  - `users.xml` (lưu tài khoản người dùng)
  - `products.xml` (lưu thông tin sản phẩm)
  - `sales.xml` (lưu thông tin giao dịch bán hàng)
- Thư mục `images/` chứa ảnh sản phẩm.

### ▶️ 4.2 Các bước chạy
1. Mở **NetBeans IDE**.
2. Chọn **File > Open Project**, rồi chọn thư mục dự án chứa mã nguồn.
3. Kiểm tra thư mục `data/` có đủ các file XML và thư mục `images/` có ảnh sản phẩm.
4. Nhấn **Run** (hoặc phím tắt `F6`) để chạy chương trình.
5. Giao diện đăng nhập xuất hiện, nhập tài khoản và mật khẩu đã được cung cấp.
6. Sau khi đăng nhập thành công, giao diện chính sẽ hiển thị các chức năng quản lý.

---


## 📂 5. Cấu trúc thư mục dự án

ShopGiay/
│
├── src/
│ ├── gui/ # Các lớp giao diện người dùng
│ ├── model/ # Lớp xử lý dữ liệu và thao tác với XML
│ ├── utils/ # Các tiện ích hỗ trợ (đọc, ghi XML, xử lý ảnh)
│ └── Main.java # Lớp chính khởi chạy chương trình
│
├── data/
│ ├── products.xml # Lưu trữ thông tin sản phẩm giày dép
│ ├── users.xml # Lưu trữ tài khoản đăng nhập
│ └── sales.xml # Lưu trữ lịch sử bán hàng
│
├── images/ # Thư mục chứa hình ảnh sản phẩm
│
└── README.md # File hướng dẫn sử dụng 



## 👨‍💻 NHÓM THỰC HIỆN

- **Nhóm 6**
- **Thành viên**:
Tạ Công Chiến	23010209
Phạm Bá Hiếu 	23010216
Nguyễn Hữu Nghĩa 	21012081
