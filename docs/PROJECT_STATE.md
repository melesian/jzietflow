# jZietflow - Project State

## Project Identity
    - Name : jZietflow (java version of Zietflow, which was a online version)
    - Type : Desktop Software (Personal Work Management System)
    - Purpose : This is to help a solo developer manage their projects,
        tasks, schedules and content around their development.
    - Current Version : 0.1.0
    - Development Status : Foundation

## Product Vision
    jZ is intended to become a useful, production grade software 
    I use to manage my portfolio and day to day tasks around software
    development.

    This project should be offline-first desktop app.

    The application should eventually provide the following:
        -> Dashboard
        -> Project Management
        -> Task Management
        -> Kanban Workflow
        -> Reminders
        -> Content Planning
        -> Settings
        -> Data Storage
        -> Backup and Recovery

## Primary User
    Any solo developer who needs a software to manage:
        -> Projects
        -> Tasks
        -> Plans
        -> Deadlines
        -> Events
        -> Activities
        -> Progress

## Technology
    Language : Java
    Build System : Maven
    UI : JavaFX
    Database : SQLite
    Primary OS : Windows
    Version Control : Git
    Remote Repo : Github

## Architecture
    Modular Software Architecture.

    Initial direction:

    JavaFX Presentation -> App Services -> Domain -> Persistence

    Note: JavaFX should only handle UI, no business logic or services.

## Planned Major Domains
    Initial domain include:
        -> Project
        -> Task
        -> Milestone
        -> Calendar Event
        -> Reminder
        -> Content Post
        -> Content Platform
        -> Note
        -> resource
        -> Setting

## Planned Application Sections
    This software will contain these as planned: 
        -> Home Page
        -> Calendar Page
        -> Projects Page
        -> Content Page
        -> Settings Page

## Development Method

    Development will be organized into: 

    Versions -> Tickets -> Implementation -> Testing -> State Update

## Current Version

    Version 0.1 - Foundation
    
    Objective: Establish software foundation, project structure, documentation,
    Git repo, JavaFX foundation and initial persistence architecture.

## Completed Tickets
    none

## Current Ticket
    [X] TICKET 001 - establish the jZ Project
    [X] TICKET 002 - creating an empty application
    [X] TICKET 003 - added navigation and page nav buttons
    [X] TICKET 004 - creating Application shell & page classes
    [X] TICKET 005 - created page state.
    [X] TICKET 006 - created the main config file
    [X] TICKET 007 - created Project domain [Domain Layer]
    [X] TICKET 008 - created ProjectService [Application Layer]
    [X] TICKET 009 - connected Domain Layer and Application Layer
    [X] TICKET 010 - created a Create Project Form
    [X] TICKET 011 - created a ProjectRepository and connected it to ProjectService
    [X] TICKET 012 - created a SQLite implementation
    [X] TICKET 013 - show projects and refresh as a new project is added
    [X] TICKET 014 - created a Project delete feature
    [X] TICKET 015 - created a Project edit feature
    [X] TICKET 016 - created a Project complete field - description


## Next Tickets
    not set

## Known Problems
    none

## Technical Debt
    none

## Architecture Decisions
    ADR-001 Desktop-first App
    jZ will initially be developed as a desktop app.

    ADR-002 Offline-first
    The core app should remain useful without being connected.

    ADR-003 Local-first data
    Data should primarily be stored locally first.

    ADR-004 Modular architecture
    This app will be structured into modules. So that
    presentation, application logic, domain logic and infrastructure 
    remain separated.

## Database
    Initial DB: SQLite
    Planned to research a suitable DB for more features later.

## Security
    Not yet fully defined. 

## Distribution
    Target : Windows Computer

    Future Distributions: 
        -> packaged Java runtime
        -> Windows Installer
        -> App Versioning
        -> App updates

## Testing
    Not yet implemented

    Future Testing will include:
        -> Unit Tests
        -> App/Service Tests
        -> Persistent Tests
        -> UI tests

## Lessons Learnt
    001 : How to properly document and start a Java Desktop Software Project.
    002 : Creating a basic hello world JavaFX project.
    003 : Stage, Scene, Node and Layout.
    004 : Dependency Injection.
    005 : UUID
    006 : Composition root.
    007 : JavaFX forms
    008 : Repository, created a ProjectRepository
    009 : Integrating SQLlite database

## Future Ideas
    Ideas that are not yet part of the first version:
        -> Cloud Sync
        -> Mobile App
        -> AI Features
        -> Multi user support
        -> Microservices
        -> Remote Backend
        -> Social Media API automation
        -> Distributed Deployment

## Current Development Context
    I am learning professional Java and JavaFX while building jZietflow.

    This project should prioritize:
        -> Understanding over blind copying
        -> First principles
        -> Maintainable design
        -> Incremental Development
        -> Testing
        -> Docs
        -> Git Discipline
        -> Software Engineering Practices