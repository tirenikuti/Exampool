# <div align="center">COMP 3350 GROUP 16
##<div align="center"> _EXAMPOOL_

Exampool aims to implement several features to function optimally. Features such as: Creating Flashcards, Notes, and Quizzes as well as searching for these resources through a database. To implement these features, we implemented a three-tier architecture for Exampool. This three-tier architecture consists of a Presentation layer (Android Interface), a Logic layer (Java Source code) and a Data layer (also Java Source code). 

The features need to work together and coherently and to achieve this, in this iteration, we implemented the creation of Flashcards, Notes and the ability to search for these Flashcards and Notes in a database.

### Flashcards
> `Flashcards.java` is implemented by creating a question through the `Question` enum and then displaying the Question's Tag on the front of the flashcard and the Question's Answer on the back of the flashcard. Due to the complexity of the various questions that can be asked, we developed 4 types of questions (subclasses) that can be displayed on these flashcards.
1.	Long-answer Questions : These are questions that have a and either a one-word answer or a full sentence as an answer 
2. Short-answer Questions : These are questions that function in a "fill in the blank" format where a word is omitted from a sentence and that omitted word serves as the answer to the question
3. Multiple choice Question : These are questions with multiple choices. Our MultipleChoiceQuestion.class requires the user to input 4 possible choices and randomly assigns to these choices a random tag ranging from A-D. The Question displayed in this case consists of the options available and the back contains the correct answer + correct tag.
4. True/False Questions : These are questions that require an answer true or false. The question tag displayed in this case includes the TRUE/FALSE option and the correct answer is displayed on the back

> These 6 class files all work in tandem with the Flashcard class to create and operate Flashcards in the logic layer

### Notes
> `Notes.java` is implemented using a user's ID (supplied at login), an ID for the specific note, and a string of the Note's content. These plus an Arraylist of the Note's tags are used to implement the Notes logic layer

### Tags
1. `Tags.java` is the object tags which will be given to notes and flashcards to allow for searching. 
2. `TagsList.java` is a list of all tags that have been created in the form of an arraylist





DIAGRAM OF ARCHITECTURE

                                      ┌────────────────────────────────────────┐
                                      │                                        │
                                      │                                        │
                                      │                                        │◄────┐
                                   ┌──►            ANDROID DISPLAY LAYER       │     │
                                   │  │                                        │     │
                                   │  │                                        │     │
                                   │  │                                        │     │
                                   │  └────────────────────┬───────────────────┘     │
                                   │                       │                         │
                                   │                       │                         │
                                   │                       │                         │
             ┌─────────────────────┼───────────────────────┼─────────────────────────│
             │                     │                       │                         │                     
             │                     │                       │                         │                     
             │                     │                       │                    SEND TO DISPLAY            
             │                SEND TO DISPLAY              │                         │                     
             │                     │                       │                         │                     
┌────────────┴────────────────┐    │      ┌────────────────┴───────────────┐         │    
│                             │    │      │                                │         │                                 
│                             │    │      │                                │         │                                
│                             │    │      │                                │         │                                 
│      NOTES                  │    │      │       FLASHCARDS               │         │    
│                             │    │      │                                │         │                                 
│                             │    │      │                                │         │                                
│                             │    │      │ ┌──────────────────────┐       │         │                               
└──────────┬──────────────────┘    │      └─┤QUESTION              ├───────┘         │    
           │                       │        │                      │                 │                                         
           │                       │        │LongAnswerQuestion    │                 │                                         
           │                       │        │ShortAnswerQuestion   │                 │                                         
           │                       │        │MultipleChoiceQuestion│                 │                                         
           │                       │        │TrueFalseQuestion     │                 │                                
           │                       │        └─────────┬────────────┘                 │                   
           │                       │                  │                              │                   
           │                       │                  │                              │                   
           │                       │                  └──────────────────────────────┐              
           │                       │                                                 │              
        STORE IN DATABASE          │                                                 │              
           │                       │                                           STORE IN DATAB        
           │                       │                                                  │              
           │                       │                                                  │              
           │            ┌──────────┴───────────────┐                           ┌──────▼──────┴────────────┐
           │            │                          │                           │                          │
           │            │                          │                           │                          │
           │            │                          │                           │                          │
           │            │                          │                           │                          │
           │            │                          │◄──────────────────────────┤     FLASHCARDS           │
           │            │     NOTES                │                           │     DATABASE             │
           └───────────►│     DATABASE             │                           │                          │
                        │                          │                           │                          │
                        │                          │                           │                          │
                        │                          ├──────────────────────────►│                          │
                        │                          │                           │                          │
                        │                          │                           │                          │
                        │                          │                           │                          │
                        │                          │                           │                          │
                        └──────────────────────────┘                           └──────────────────────────┘
                               ▲                                                                  ▲        
                               │                                                                  │        
                               │                                                                  │        
                               │                                                                  │        
                               │                                                                  │        
                               │                                                                  │        
                               └─────────────────────RETRIEVE┼FROM┼DATABASE───────────────────────┴
