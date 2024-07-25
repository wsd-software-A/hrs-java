// const reservationHandler = () => {
//   const reservationForm = document.getElementById("reservationForm");

//   console.log(reservationForm);

//   reservationForm.addEventListener("submit", (event) => {
//     event.preventDefault();

//     const formData = new FormData(reservationForm);
//     console.log("hoge");
//     const data = {
//       year: formData.get("year"),
//       month: formData.get("month"),
//       date: formData.get("date"),
//     };

//     console.log(data);

//     console.log("Reservation successful!");
//     // Javaのコントローラにデータを送信
//     fetch("http://localhost:8080/api/reservation", {
//       method: "POST",
//       headers: {
//         "Content-Type": "application/json",
//       },
//       body: JSON.stringify(data),
//       dataType: "json",
//     }).then((response) => {
//       if (response.ok) {
//         reservationMessage.innerText = "Reservation successful!";
//         console.log("Reservation successful!");
//         reservationForm.reset();
//       } else {
//         reservationMessage.innerText = "Reservation failed!";
//       }
//     });
//   });
// };

// $("form").submit(function () {
//   var data = $(this).serialize();
//   $.ajax({
//     url: "http://localhost:8080/api/reservation",
//     type: "POST",
//     data: data,
//     success: function (data) {
//       console.log(data);
//     },
//     error: function (data) {
//       console.log(data);
//     },
//   });
//   return false;
// });
