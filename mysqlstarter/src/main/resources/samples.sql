

1     mvn exec:java -D exec.mainClass="org.h2.tools.Server" -D exec.args="-tcp -tcpAllowOthers -tcpPort 9092 "
УСПІХ  вивело на консоль :  TCP server running at tcp://localhost:9092 (others can connect)

2     стартуємо приклад в джаві
3     mvn exec:java -D exec.mainClass="org.h2.tools.Server" -D exec.args="-web -webAllowOthers -webPort 8082"

docker run --name my-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -p 3306:3306 -d mysql:latest

SELECT * FROM AUTHOR
drop table articles

CREATE TABLE
                articles(
                    id  int NOT NULL  AUTO_INCREMENT,
                     title VARCHAR(100),
                     author_id INT NOT NULL,
                     text VARCHAR(300),
                     PRIMARY KEY (id),
                     FOREIGN KEY (author_id) REFERENCES author(id))
delete from articles


INSERT INTO  articles(title, text, author_id) VALUES('first','some long text', 1)
INSERT INTO  articles(title, text, author_id) VALUES('third','some  another  other long text', 2)

select * from author  where name ='Alice' or id =2


SELECT * FROM author AS a, articles AS art WHERE a.id = art.author_id

SELECT * FROM author AS a
 JOIN articles AS art ON a.id = art.author_id



CREATE TABLE
                tag(
                    id IDENTITY NOT NULL  PRIMARY KEY,
                     name VARCHAR(20))

CREATE TABLE
                article_tag(
                     article_id BIGINT NOT NULL,
                     tag_id BIGINT NOT NULL ,
                     FOREIGN KEY (article_id) REFERENCES articles(id),
                     FOREIGN KEY (tag_id) REFERENCES tag(id)
)


insert into  tag(name) values('funny')
insert into tag(name) values('nature')
insert into tag(name) values('sport')

insert into article_tag(article_id, tag_id) values(5,2)

select * from article_tag

select * from articles

-- authors   who has funny articles.

SELECT * FROM author AS a
 LEFT  JOIN articles AS art ON a.id = art.author_id
 LEFT  JOIN article_tag AS at  ON at.article_id = art.id
LEFT JOIN tag AS t ON t.id = at.tag_id
WHERE t.name='funny'

SELECT a.id, a.name FROM articles AS art
 LEFT  JOIN author AS a ON a.id = art.author_id
 LEFT  JOIN article_tag AS at  ON at.article_id = art.id
LEFT JOIN tag AS t ON t.id = at.tag_id
WHERE t.name='funny'



