---
title: Data Model
description: "Entity-relationship diagram and DDL."
menu: Data Model
order: 20
uml:
  image: img/uml.svg
  pdf: pdf/uml.pdf
ddl: sql/ddl.sql
erd:
  image: img/erd.svg
  pdf: pdf/erd.pdf
---

{% include ddc-abbreviations.md %}

{% include uml.md %}

{% include erd.md %}

{% include ddl.md %}

## Entity Classes
- [`edu.cnm.deepdive.leavemealone.entity.Location`](api/src-html/edu/cnm/deepdive/leavemealone/model/entity/Location.html){:target="_blank"}
- [`edu.cnm.deepdive.leavemealone.entity.Alert`](api/src-html/edu/cnm/deepdive/leavemealone/model/entity/Alert.html){:target="_blank"}

## DAOs
- [`edu.cnm.deepdive.leavemealone.dao.LocationDao`](api/src-html/edu/cnm/deepdive/leavemealone/model/dao/LocationDao.html){:target="_blank"}
- [`edu.cnm.deepdive.leavemealone.dao.AlertDao`](api/src-html/edu/cnm/deepdive/leavemealone/model/dao/AlertDao.html){:target="_blank"}

## Database
- [`edu.cnm.deepdive.leavemealone.service.LeaveMeAloneDatabase`](api/src-html/edu/cnm/deepdive/leavemealone/service/LeaveMeAloneDatabase.html){:target="_blank"}
