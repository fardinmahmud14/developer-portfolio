# Developer Portfolio — Spring Boot + Thymeleaf

A responsive personal portfolio built with Java 21, Spring Boot 4.1.2, Spring MVC, Thymeleaf and Bootstrap 5. It includes About, Skills, Projects and a server-validated Contact form.

## Requirements

- JDK 21
- IntelliJ IDEA (Maven support enabled)
- Internet connection for the first Maven dependency download and the Bootstrap / Google Fonts CDNs
- Docker Desktop only if you want to test the container locally

## Open and run in IntelliJ IDEA

1. Extract the ZIP file.
2. In IntelliJ IDEA, choose **File → Open** and select the extracted `developer-portfolio` folder (the folder containing `pom.xml`).
3. Set the Project SDK to **Java 21** under **File → Project Structure → Project**.
4. Allow IntelliJ to load and synchronize the Maven project.
5. Open `DeveloperPortfolioApplication.java` and click the green Run icon beside the `main` method.
6. Visit <http://localhost:8080> in your browser.

You can also run `mvn spring-boot:run` from a terminal if Maven is installed and configured on your computer.

## Important files

```text
developer-portfolio/
├── src/main/java/com/portfolio/developerportfolio/
│   ├── DeveloperPortfolioApplication.java
│   ├── controller/PortfolioController.java
│   ├── model/ContactMessage.java
│   ├── model/PortfolioProject.java
│   └── service/ContactService.java
├── src/main/resources/
│   ├── templates/index.html
│   ├── static/css/style.css
│   ├── static/js/script.js
│   └── application.properties
├── Dockerfile
├── render.yaml
└── pom.xml
```

## Personalize the portfolio before publishing

Search the project for these demo values and replace them with your real details:

- `Fardin Mahmood`, university, location and profile text in `templates/index.html`
- `hello@example.com` with your public contact email
- `yourusername` in GitHub and LinkedIn links
- Project names, descriptions, technology lists and repository URLs in `PortfolioController.java`
- Add your CV and profile / project images under `src/main/resources/static/images/`

## Contact form note

The form validates submissions on the server and the demo service keeps submissions in memory while the application process is running. It does **not** send email or save messages permanently. The queue is cleared whenever the application restarts. Before using this as a real contact channel, connect an email provider or a persistent database and add suitable spam protection.

## Test with Docker

From the project root:

```bash
docker build -t developer-portfolio .
docker run --rm -p 8080:8080 -e PORT=8080 developer-portfolio
```

Then open <http://localhost:8080>.

## Deploy to Render

This repository includes a `Dockerfile` and a `render.yaml` Blueprint.

1. Create a GitHub repository and push this project to the `main` branch.
2. In Render, choose **New → Blueprint** and connect the GitHub repository containing `render.yaml`.
3. Review the `developer-portfolio` web service and deploy it.
4. Render will build the Docker image and publish the service. The application reads Render's `PORT` environment variable.
5. Open the generated `onrender.com` URL and test the homepage and contact form.

The included Blueprint selects Render's Free plan. Free web services can sleep when idle and may take a little time to respond to the first request after inactivity. Check Render's current plan details before deploying, because hosting-plan terms can change.

## Tech stack

- Java 21
- Spring Boot 4.1.2
- Spring MVC
- Thymeleaf
- Jakarta Bean Validation
- Bootstrap 5.3.3
- Maven
- Docker
- Render
