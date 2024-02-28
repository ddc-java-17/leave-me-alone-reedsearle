# Entity Operations Checklist

## Entity name: Location

## Operations

In the list of operations below, check all the operations that apply. For example, if you know you will need to be able to insert a single instance of the entity at a time into the database, check **Single instance** in the **Create/insert** section.

Note that the pairs of square brackets below are rendered as checkboxes in GitHub Pages. To insert a checkmark, **replace** the single space between the square brackets in the Markdown with an "x" character (uppercase or lowercase; **do not** include the quote characters). To remove a checkmark, **replace** the "x" between the square brackets with a **single** space character. Aside from adding or removing checkmarks, do not modify the formatting or content of the remainder of this section.

### Create/insert
    
* [x] Single instance 
* [ ] Multiple instances 
    
### Read/query/select

* [x] Single instance 
* [x] Multiple instances 

### Update

* [x] Single instance 
* [ ] Multiple instances 

### Delete

* [x] Single instance 
* [x] Multiple instances 


## Queries

For any queries (i.e. selecting from the database) that you think you will need to do with this entity, summarize the purpose of the query (what functionality in your application will use the query), whether the query is intended to return a single instance or multiple instances (and whether returning no instances is a valid possibility), what field(s)/column(s) of your entity will be used as filter criteria, and in what order the results (if multiple) should be returned.

Copy and paste the section below as many times as necessary, for all of the queries you currently anticipate implementing for this entity.

### All locations

Purpose

: Select all locations in the database

Cardinality/modality

: Cardinality - Many locations may be selected at once.  Modality - optional as the database may not yet have any locations saved

Filter

: None

Sort order

: None



### Secure or Unsecure locations

Purpose

: Select all locations that are secure or all locations that are unsecure in the database

Cardinality/modality

: Cardinality - Many locations may be selected at once.  Modality - optional as the database may not yet have any locations saved

Filter

: Where secure is either true (secure locations) or false (unsecure locations)

Sort order

: None


### All locations that are tracked

Purpose

: Select all locations in the database that are being tracked.  The tracked field is set when the app determines the phone is stolen.

Cardinality/modality

: Cardinality - Many locations may be selected at once.  Modality - optional as the database may not yet have any locations saved

Filter

: Where tracked is true

Sort order

: timestamp(ascending)


### All locations within a specified timeframe and secure/unsecure

Purpose

: Select all locations in the database within a certain timeframe and specify secure or unsecure locations

Cardinality/modality

: Cardinality - Many locations may be selected at once.  Modality - optional as the database may not yet have any locations saved

Filter

: Where timestamp is within two hour parameters and secure is specified

Sort order

: None


## Truncate location

Purpose

: Remove location from database based on location_id, secure, or tracked fields

Cardinality/modality

: Cardinality - One or Many locations may be selected at once.  Modality - optional as the database may not yet have any locations saved

Filter

: Where location_id, secure, or tracked is specified

Sort order

: None


