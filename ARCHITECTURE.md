## ARCHITECTURE
Exampool aims to implement features such as: 

- Creating Flashcards, Notes, and Quizzes
    - Quizzes will be implemented by going through flashcards and answering questions on the flashcard, with the answer at the back
- Searching for these resources

To implement these features, we implemented a three-tier architecture for Exampool. This three-tier architecture consists of a Presentation layer (Android Interface), a Logic layer (Java Source code) and a Persistence layer (through HSQLDB). 

```{mermaid}
graph LR
  subgraph Persistence Layer
    DB(Local Database)
    API(Remote API)
  end

  subgraph Logic Layer
    UseCase(Business Logic)
    Repository(Data Access Objects)
  end

  subgraph Presentation Layer
    ViewModel(UI State Management)
    View(UI Components)
  end

  DB -.-> Repository
  API -.-> Repository
  Repository -.-> UseCase
  UseCase -.-> ViewModel
  ViewModel -.-> View
```


