## 1. Nguyên tắc vi phạm
Việc lặp lại đoạn code `model.addAttribute("categories", ...)` ở cả 3 hàm GET (add, edit, search) đang vi phạm nghiêm trọng 2 nguyên tắc lập trình:

* **Nguyên tắc DRY (Don't Repeat Yourself):** Không lặp lại chính mình. Cùng một khối logic lấy danh sách nhưng lại bị nhúng thủ công vào nhiều nơi rải rác.
* **Nguyên tắc SRP (Single Responsibility Principle) trong SOLID:** Bản thân Controller chỉ nên làm nhiệm vụ nhận request và trả về view. Việc phải tự định nghĩa và khởi tạo cục dữ liệu `categories` bên trong Controller đã làm nó gánh thêm một trách nhiệm thừa thãi, khiến Controller phình to không cần thiết.

## 2. Rủi ro về mặt bảo trì (Mở rộng 20 trang giao diện)
Nếu nhà hàng mở rộng ra 20 trang giao diện khác nhau và đều cần danh sách "Nhóm món ăn", việc giữ cách code cũ sẽ gây ra các rủi ro:

* **Các ác mộng khi sửa đổi:** Giả sử nhà hàng muốn thêm một nhóm mới là "Đồ ăn vặt". Bạn sẽ phải mở Controller lên và gõ đi gõ lại nội dung danh sách mới vào tận 20 dòng code rải rác ở 20 hàm khác nhau.
* **Nguy cơ lỗi cao (Human Error):** Khi sửa chữa bằng tay ở quá nhiều nơi, rất dễ xảy ra tình trạng "sửa sót", dẫn đến việc một số trang hiển thị danh sách mới, một số trang lại bị kẹt ở danh sách cũ.
* **Rối nùi và khó đọc:** Code bị trùng lặp khiến file Controller quá dài và chứa toàn những code setup giống hệt nhau, che khuất đi các logic nghiệp vụ (business logic) thực sự quan trọng của từng API.