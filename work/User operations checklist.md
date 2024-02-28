# Entity Operations Checklist

## Entity name: User

## Operations

In the list of operations below, check all the operations that apply. For example, if you know you will need to be able to insert a single instance of the entity at a time into the database, check **Single instance** in the **Create/insert** section.

Note that the pairs of square brackets below are rendered as checkboxes in GitHub Pages. To insert a checkmark, **replace** the single space between the square brackets in the Markdown with an "x" character (uppercase or lowercase; **do not** include the quote characters). To remove a checkmark, **replace** the "x" between the square brackets with a **single** space character. Aside from adding or removing checkmarks, do not modify the formatting or content of the remainder of this section.

### Create/insert
    
* [x] Single instance 
* [ ] Multiple instances 
    
### Read/query/select

* [x] Single instance 
* [ ] Multiple instances 

### Update

* [x] Single instance 
* [ ] Multiple instances 

### Delete

* [x] Single instance 
* [ ] Multiple instances 


## Queries

### Select user by user_id

Purpose

: Find a user by their user_id

Cardinality/modality

: Cardinality - One, Modality - optional as the user may not be in the database

Filter

: Where user = user_id

Sort order

: None


### Select user by oauth_key

Purpose

: Find a user by their oauth_key

Cardinality/modality

: Cardinality - One, Modality - optional as the user may not be in the database

Filter

: Where user = oauth_key

Sort order

: None


### Select user by display_name

Purpose

: Find a user by their display_name

Cardinality/modality

: Cardinality - One, Modality - optional as the user may not be in the database

Filter

: Where user = display_name

Sort order

: None



