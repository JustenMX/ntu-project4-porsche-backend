# Porsche Service Application - Backend

Think of it like this: the React Native frontend is the face of our app, making things look and feel great. Behind the scenes, the Spring Boot backend is the reliable engine, handling requests and making sure everything runs smoothly. Together, they create a seamless and responsive system. It's like combining the best of both worlds – React Native's flexibility and Spring Boot's reliability – for an app that works seamlessly and efficiently.

## Project Overview

**Project Name:** Porsche Service Application - Backend  
**Description:** The backend of the Porsche Service Application is developed using Java Spring Boot, providing a robust and secure foundation for managing user authentication, service center data, and future appointment scheduling functionalities.

## Key Features

### Secure Authentication

- **JWT Implementation:** Utilizes JSON Web Tokens (JWT) for secure authentication, ensuring only authenticated users gain access to protected resources.
- **Token Verification:** Frontend token verification is seamlessly integrated, enhancing security and user access control.
- **Automatic Token Clearance:** Upon user logout, the system automatically clears tokens, enhancing data security.

### Service Center Data Management

- **Current Functionality:** The backend supports the retrieval and display of the Porsche service center in Singapore.
- **Geolocation Integration:** Implements geolocation functionality to provide accurate service center locations based on user permissions.
- **Interactive Search:** Facilitates interactive searching for the Singapore service center, displaying total distance in kilometers.
- **Future Expansion:** Designed with scalability in mind, the backend is ready for expansion to include service centers in various regions.

### Database Management

- **PostgreSQL Integration:** Utilizes PostgreSQL as the database management system, ensuring data integrity and reliability.
- **Schema Design:** Follows a well-defined schema to organize and manage user data, service center details, and future appointment-related information.

## Technologies Used

- **Java Spring Boot:** The backend is developed using the Spring Boot framework, providing a scalable and modular architecture.
- **PostgreSQL:** Utilizes PostgreSQL as the relational database management system for efficient data storage.
- **JWT:** Implements JSON Web Tokens for secure user authentication.

## Future Roadmap

### Global Service Centers

- **Expansion Plan:** Future development includes expanding the service center locations feature to cover Porsche service centers in various regions.
- **Scalability:** The backend architecture is designed to seamlessly integrate new service center data, ensuring scalability as the application grows.

### Enhanced Navigation

- **Point-to-Point Navigation:** Plans include implementing point-to-point navigation features for a more immersive and user-friendly experience.
- **Geospatial Integration:** Explore incorporating geospatial technologies for enhanced navigation accuracy.

### Appointment Management

- **Appointment Creation:** Introduce the capability for users to schedule appointments with Porsche service centers directly through the mobile app.
- **Calendar Integration:** Implement integration with device calendars to provide users with reminders and easy access to their scheduled appointments.
- **Push Notifications:** Enable push notifications to keep users informed about upcoming appointments, service updates, and other relevant information.
