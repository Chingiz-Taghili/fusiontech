// Inputu silən funksiya (ilk inputu silməmək şərti ilə)
function removeImage(button) {
    const container = document.getElementById('imagesContainer');
    if (container.children.length > 1) {
        button.parentElement.remove(); // Inputu sil
    } else {
        alert("Ən azı bir şəkil qalmalıdır!");
    }
}

// Yeni image URL inputu əlavə edən funksiya
function addImageUrl() {
    const container = document.getElementById('imagesContainer');

    const inputWrapper = document.createElement('div');
    inputWrapper.style.marginBottom = '10px';
    inputWrapper.style.display = 'flex';
    inputWrapper.style.alignItems = 'center';

    const newInput = document.createElement('input');
    newInput.type = 'text';
    newInput.name = 'imagesUrl'; // Eyni adla siyahı kimi qəbul edilir
    newInput.placeholder = 'Daha bir şəkil';
    newInput.style.cssText = 'margin-right: 5px; width: 400px; height: 40px; padding: 10px; outline: none; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); border: 1px solid #ccc; border-radius: 5px;';

    // Sil düyməsi əlavə etmək
    const removeButton = document.createElement('button');
    removeButton.innerText = 'Ləğv et';
    removeButton.type = 'button';
    removeButton.className = 'btn btn-primary py-1 px-2';
    removeButton.onclick = function() {
        removeImage(this);
    };

    // Inputu və sil düyməsini div-ə əlavə etmək
    inputWrapper.appendChild(newInput);
    inputWrapper.appendChild(removeButton);
    container.appendChild(inputWrapper);
}

// Form göndərilməzdən öncə inputları yoxlayan və formu doğrulayan funksiya
function validateAndSubmitForm() {
    const container = document.getElementById('imagesContainer');
    const inputs = container.querySelectorAll('input[name="imagesUrl"]');

    let isValid = true;

    inputs.forEach(input => {
        if (input.value.trim() === '') {
            if (container.children.length > 1) {
                input.parentElement.remove(); // Boş inputları sil
            } else {
                alert("Birinci şəkil URL-i boş ola bilməz!");
                isValid = false;
            }
        }
    });

    return isValid; // Əgər bütün inputlar keçərli olsa, form təsdiqlənəcək
}

