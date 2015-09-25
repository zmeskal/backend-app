CREATE (MVC:Technology {name:'MVC'})
CREATE (FE:Technology {name:'FrontEnd MVC'})
CREATE (An:Technology {name:'Angular'})
CREATE (An1:Technology {name:'Angular 1'})
CREATE (An2:Technology {name:'Angular 2'})
CREATE (An12:Technology {name:'Angular 1.2'})
CREATE (An13:Technology {name:'Angular 1.3'})
CREATE (JS:Technology {name:'Javascript'})
CREATE (TS:Technology {name:'Typescript'})
CREATE (UI:Technology {name:'UI router'})
CREATE
  (An12)-[:IS_A]->(An1),
  (An13)-[:IS_A]->(An1),
  (An1)-[:IS_A]->(An),
  (An2)-[:IS_A]->(An),
  (An)-[:IS_A]->(FE),
  (An)-[:IS_A]->(JS),
  (An2)-[:IS_A]->(TS),
  (FE)-[:IS_A]->(MVC),
  (An1)-[:INCLUDES]->(UI)

CREATE (G:Customer {name:'Gorkana'})
CREATE (N:Customer {name:'Nomad'})
CREATE (GTM:Project {name:'Gorkana TM'})
CREATE (OBIS:Project {name:'Nomad OBIS'})
CREATE
  (G)-[:CONTRACTS]->(GTM),
  (N)-[:CONTRACTS]->(OBIS)

CREATE (MOJO:SubProject {name:'MOJO'})
CREATE (P:SubProject {name:'Portal'})
CREATE
  (GTM)-[:DIVIDES_INTO]->(MOJO),
  (GTM)-[:DIVIDES_INTO]->(P)

CREATE (OB:SubProject {name:'OnBoard'})
CREATE (M:SubProject {name:'MAS'})
CREATE
  (OBIS)-[:DIVIDES_INTO]->(OB),
  (OBIS)-[:DIVIDES_INTO]->(M)

CREATE (Bob:Developer {name:'Bob Stalmach'})
CREATE (Boris:Developer {name:'Boris Musatov'})
CREATE (JZ:Developer {name:'Jiri Zmeskal'})
CREATE (Clint:Developer {name:'Tomas Kolaci'})

CREATE (BobG:Allocation {from:'2013/07/01', to:''})
CREATE (BorisG:Allocation {from:'2015/01/01', to:''})
CREATE (ClintG:Allocation {from:'2014/01/01', to:'2014/12/31'})
CREATE (JZG:Allocation {from:'2014/01/01', to:''})
CREATE
 (BobG)-[:ALLOCATES]->(Bob),
 (BobG)-[:ONTO]->(GTM),
 (BorisG)-[:ALLOCATES]->(Boris),
 (BorisG)-[:ONTO]->(GTM),
 (ClintG)-[:ALLOCATES]->(Clint),
 (ClintG)-[:ONTO]->(GTM),
 (JZG)-[:ALLOCATES]->(JZ),
 (JZG)-[:ONTO]->(GTM)

CREATE (BobGU1:Usage {from:'2013/07/01', to:'2013/12/31'})
CREATE (BobGU2:Usage {from:'2014/01/01', to:''})
CREATE (BorisGU:Usage {from:'2015/01/01', to:'2015/06/30'})
CREATE (ClintGU:Usage {from:'2014/07/01', to:'2014/31/12'})
CREATE
  (BobG)-[:USES]->(BobGU1),
  (BobGU1)-[:ON_SUBPROJECT]->(P),
  (BobGU1)-[:USE_OF]->(An12),
  (BobGU1)-[:USE_OF]->(An13),

  (BobG)-[:USES]->(BobGU2),
  (BobGU2)-[:ON_SUBPROJECT]->(MOJO),
  (BobGU2)-[:USE_OF]->(An2),
  (BobGU2)-[:USE_OF]->(UI),

  (BorisG)-[:USES]->(BorisGU),
  (BorisGU)-[:ON_SUBPROJECT]->(MOJO),
  (BorisGU)-[:USE_OF]->(UI),

  (ClintG)-[:USES]->(ClintGU),
  (ClintGU)-[:ON_SUBPROJECT]->(P),
  (ClintGU)-[:USE_OF]->(UI)

CREATE (Jan:Developer {name:'Jan Barta'})
CREATE (Ondra:Developer {name:'Ondrej Holenda'})
CREATE (Ivo:Developer {name:'Ivo Komarek'})
