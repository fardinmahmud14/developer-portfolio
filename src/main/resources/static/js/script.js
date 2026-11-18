document.addEventListener('DOMContentLoaded', () => {
    const yearElement = document.getElementById('currentYear');
    if (yearElement) {
        yearElement.textContent = new Date().getFullYear();
    }

    // Close the mobile navigation after a visitor selects a section.
    const navigation = document.getElementById('mainNavigation');
    if (navigation && window.bootstrap) {
        navigation.querySelectorAll('a.nav-link, a.nav-cta').forEach((link) => {
            link.addEventListener('click', () => {
                if (window.innerWidth < 992 && navigation.classList.contains('show')) {
                    window.bootstrap.Collapse.getOrCreateInstance(navigation).hide();
                }
            });
        });
    }

    // Add a subtle active state to the navigation link for the visible section.
    const sections = document.querySelectorAll('main section[id]');
    const navLinks = document.querySelectorAll('.navbar .nav-link');
    if ('IntersectionObserver' in window && sections.length && navLinks.length) {
        const observer = new IntersectionObserver((entries) => {
            entries.forEach((entry) => {
                if (entry.isIntersecting) {
                    navLinks.forEach((link) => {
                        link.classList.toggle('active', link.getAttribute('href') === `#${entry.target.id}`);
                    });
                }
            });
        }, { rootMargin: '-35% 0px -55% 0px' });
        sections.forEach((section) => observer.observe(section));
    }
});
