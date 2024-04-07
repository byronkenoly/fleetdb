class VerticalNavbar extends HTMLElement {
    connectedCallback(){
        this.innerHTML = `
            <nav class="navbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link">
                            <span class="material-symbols-outlined">airport_shuttle</span>
                            <span class="link-text">Vehicles</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link">
                            <span class="material-symbols-outlined">payments</span>
                            <span class="link-text">Invoices</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link">
                            <span class="material-symbols-outlined">request_quote</span>
                            <span class="link-text">Quotations</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link">
                            <span class="material-symbols-outlined">speed</span>
                            <span class="link-text">Mileage</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link">
                            <span class="material-symbols-outlined">description</span>
                            <span class="link-text">Work Instructions</span>
                        </a>
                    </li>
                </ul>
            </nav>
        `
    }
}

customElements.define('vertical-navbar', VerticalNavbar)