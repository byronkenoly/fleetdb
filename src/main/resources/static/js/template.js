class VerticalNavbar extends HTMLElement {
    connectedCallback(){
        this.innerHTML = `
            <nav class="navbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a href = "/vehicles" class="nav-link">
                            <span class="material-symbols-outlined">airport_shuttle</span>
                            <span class="link-text">Vehicles</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href = "/workInstructions" class="nav-link">
                            <span class="material-symbols-outlined">description</span>
                            <span class="link-text">Work Instructions</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href = "/quotations" class="nav-link">
                            <span class="material-symbols-outlined">request_quote</span>
                            <span class="link-text">Quotations</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href = "/invoices" class="nav-link">
                            <span class="material-symbols-outlined">payments</span>
                            <span class="link-text">Invoices</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href = "/mileage" class="nav-link">
                            <span class="material-symbols-outlined">speed</span>
                            <span class="link-text">Mileage</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href = "/serviceTracker" class="nav-link">
                            <span class="material-symbols-outlined">engineering</span>
                            <span class="link-text">Maintenance</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href = "/serviceTracker" class="nav-link">
                            <span class="material-symbols-outlined">schedule</span>
                            <span class="link-text">Schedule</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href = "/checklist" class="nav-link">
                            <span class="material-symbols-outlined">list</span>
                            <span class="link-text">Checklist</span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href = "/staff" class="nav-link">
                            <span class="material-symbols-outlined">groups</span>
                            <span class="link-text">Staff</span>
                        </a>
                    </li>
                </ul>
            </nav>
        `
    }
}

customElements.define('vertical-navbar', VerticalNavbar);