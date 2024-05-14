function addHeadContent() {

    let favicon = document.createElement('link');
    favicon.setAttribute('rel', 'icon');
    favicon.setAttribute('type', 'image/png');
    favicon.setAttribute('sizes', '16x16');
    favicon.setAttribute('href', '/img/favicon-16x16.png');
    document.head.appendChild(favicon);

    let preconnect1 = document.createElement('link');
    preconnect1.setAttribute('rel', 'preconnect');
    preconnect1.setAttribute('href', 'https://fonts.googleapis.com');
    document.head.appendChild(preconnect1);

    let preconnect2 = document.createElement('link');
    preconnect2.setAttribute('rel', 'preconnect');
    preconnect2.setAttribute('href', 'https://fonts.gstatic.com');
    preconnect2.setAttribute('crossorigin', '');
    document.head.appendChild(preconnect2);

    let montserratFont = document.createElement('link');
    montserratFont.setAttribute('href', 'https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap');
    montserratFont.setAttribute('rel', 'stylesheet');
    document.head.appendChild(montserratFont);

}

function mainCss() {

    let stylesheet = document.createElement('link');
    stylesheet.setAttribute('rel', 'stylesheet');
    stylesheet.setAttribute('href', '/styles/main.css');
    document.head.appendChild(stylesheet);

    let materialFont = document.createElement('link');
    materialFont.setAttribute('href', 'https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,100,0,0');
    materialFont.setAttribute('rel', 'stylesheet');
    document.head.appendChild(materialFont);
}

function newItemCss() {

    let stylesheet = document.createElement('link');
    stylesheet.setAttribute('rel', 'stylesheet');
    stylesheet.setAttribute('href', '/styles/newItem.css');
    document.head.appendChild(stylesheet);
}