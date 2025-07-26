

### 👟🥿 PHẦN MỀM QUẢN LÝ SHOP GIÀY 📋

#### 1. Giới thiệu phần mềm Quản Lý 
Shop Giày là phần mềm quản lý bán hàng chuyên dụng cho cửa hàng giày dép, được phát triển bằng Java trên môi trường NetBeans IDE, sử dụng XML làm hệ thống lưu trữ dữ liệu.

Phần mềm hỗ trợ cửa hàng trong các công việc:

Quản lý thông tin sản phẩm giày dép

Quản lý khách hàng và hóa đơn mua hàng

Thống kê doanh thu, hàng tồn

Tìm kiếm thông minh theo nhiều tiêu chí

Giao diện thân thiện, dễ sử dụng, hỗ trợ cả nhân viên bán hàng và quản lý

#### ⚙️ 2. Các chức năng chính 🔐

##### 2.1 Đăng nhập hệ thống Trước khi truy cập hệ thống, người dùng bắt buộc phải đăng nhập.

Thông tin đăng nhập được lưu trong file users.xml.

Mỗi tài khoản gồm tên đăng nhập và mật khẩu.

Phân quyền người dùng bao gồm:

Admin: toàn quyền quản lý (thêm/xóa tài khoản, sản phẩm, khách hàng)

Nhân viên: tạo hóa đơn, thêm khách hàng

✅ Tài khoản mặc định:

👤 Tài khoản: admin

🔑 Mật khẩu: admin

Người dùng có thể tự tạo thêm tài khoản mới hoặc chỉnh sửa file users.xml để thay đổi thông tin người dùng.

##### 👟 2.2 Quản lý sản phẩm (dữ liệu lưu trong dataShoes.xml) Phần mềm cho phép quản lý toàn bộ danh sách sản phẩm giày dép trong cửa hàng.

Thêm mới sản phẩm:

Mã sản phẩm tự động tăng (G001, G002, ...)

Nhập thông tin: tên, size, màu sắc, giá bán, số lượng tồn, hình ảnh

Chỉnh sửa sản phẩm:

Cập nhật thông tin sản phẩm khi có thay đổi về giá, tồn kho,...

Xóa sản phẩm:

Xóa sản phẩm không còn kinh doanh

Hiển thị danh sách sản phẩm:

Giao diện bảng rõ ràng, có ảnh minh họa sản phẩm

Lưu trữ dữ liệu:

Tất cả dữ liệu sản phẩm được lưu trong file dataShoes.xml

Thông tin chi tiết cho mỗi sản phẩm gồm:

🆔 Mã sản phẩm (tự động, ví dụ: G001)

🏷️ Tên sản phẩm

📏 Size giày

🎨 Màu sắc

💰 Giá bán (hiển thị với dấu phân cách hàng nghìn)

📦 Số lượng tồn kho

🖼️ Ảnh sản phẩm (ảnh nằm trong thư mục images/)

##### 👤 2.3 Quản lý khách hàng và hóa đơn (dữ liệu lưu trong dataKhachHang.xml) 🧑‍💼 Quản lý khách hàng Thêm khách hàng mới: mã tự động tăng (KH001, KH002, ...)

Cập nhật thông tin khách hàng: họ tên, địa chỉ, số điện thoại

Tìm kiếm khách hàng theo tên hoặc mã

Hiển thị danh sách khách hàng kèm số hóa đơn đã mua

Thông tin khách hàng gồm:

🆔 Mã khách hàng

🧾 Họ và tên

☎️ Số điện thoại

📍 Địa chỉ

🧾 Quản lý hóa đơn Tạo hóa đơn mới cho khách hàng:

Lựa chọn sản phẩm, nhập số lượng

Tự động tính tổng tiền

Chọn ngày mua hàng từ lịch

Mã hóa đơn tự tăng (HD001, HD002, …)

Lưu hóa đơn:

Mỗi hóa đơn được lưu trong danh sách hóa đơn của khách hàng tương ứng

Hiển thị chi tiết hóa đơn:

Danh sách sản phẩm đã mua, số lượng, đơn giá, tổng tiền

Tìm kiếm hóa đơn theo mã, ngày, khách hàng

##### 🔍 2.4 Tìm kiếm sản phẩm nâng cao Phần mềm hỗ trợ chức năng tìm kiếm thông minh, linh hoạt theo nhiều tiêu chí:

🆔 Mã sản phẩm (tìm chính xác)

🏷️ Tên sản phẩm (tìm gần đúng – không cần nhập đầy đủ)

💵 Giá bán (tìm theo khoảng giá)

👉 Kết quả hiển thị theo bảng kèm ảnh sản phẩm, giúp dễ nhận diện.

##### 📊 2.5 Thống kê và báo cáo Chức năng thống kê 
giúp quản lý nắm được tình hình hoạt động kinh doanh: 

Hóa đơn cao nhất hóa đơn thấp nhất

Tổng doanh thu (hiển thị theo định dạng tiền tệ có dấu phẩy)

Sản phẩm tồn kho còn lại

👉 Giao diện thống kê hiển thị dạng bảng trực quan, dễ theo dõi.

#### 🚀 3. Hướng dẫn cài đặt và sử dụng 
##### 🛠️ 3.1 Yêu cầu môi trường ✅
Java JDK 17 hoặc cao hơn (khuyến nghị: JDK 23)

✅ NetBeans IDE phiên bản 21 hoặc mới hơn

✅ Các file dữ liệu cần thiết:

dataShoes.xml – chứa danh sách sản phẩm

dataKhachHang.xml – chứa danh sách khách hàng và hóa đơn

✅ Thư mục images/ – chứa ảnh sản phẩm giày

##### ▶️ 3.2 Cách chạy chương trình Mở NetBeans IDE

Chọn File > Open Project và chọn thư mục chứa dự án

Đảm bảo thư mục data/ có các file dataShoes.xml, dataKhachHang.xml, users.xml

Đảm bảo thư mục images/ có ảnh sản phẩm (tên ảnh phải đúng với đường dẫn lưu trong XML)

Nhấn Run hoặc nhấn phím F6 để chạy phần mềm

Tại giao diện đăng nhập, nhập:

👤 Tài khoản: admin

🔑 Mật khẩu: admin

Sau khi đăng nhập thành công, giao diện chính sẽ hiển thị đầy đủ chức năng quản lý

#### 👨‍💻 4. Nhóm phát triển Nhóm 6 – Dự án : Quản Lý Shop Giày

👤 Tạ Công Chiến – 23010209

👤 Phạm Bá Hiếu – 23010216

👤 Nguyễn Hữu Nghĩa – 21012081

>>>>>>> 1999882 (hoàn thành)
