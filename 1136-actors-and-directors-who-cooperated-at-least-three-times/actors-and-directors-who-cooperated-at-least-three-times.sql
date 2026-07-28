select distinct t1.actor_id,t1.director_id from ActorDirector as t1
where 3 <= (select count(*) from ActorDirector as t2 where t1.actor_id = t2.actor_id and t1.director_id = t2.director_id)