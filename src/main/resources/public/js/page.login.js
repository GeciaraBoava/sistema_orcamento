document.addEventListener("DOMContentLoaded", function () {
    const checkboxes = document.querySelectorAll(".sm-checkbox input[type='checkbox']");

    checkboxes.forEach(function (checkbox) {
        const icon = checkbox.parentElement.querySelector(".check-icon");
        icon.style.opacity = checkbox.checked ? "1" : "0";

        checkbox.addEventListener("change", function () {
            icon.style.opacity = checkbox.checked ? "1" : "0";
        });
    });
});
