import psycopg2
import random


names = ["Александр", "Иван", "Михаил", "Артем", "Дмитрий", "Егор", "Максим", "Никита", "Сергей", "Юрий", "Анастасия", "Екатерина", "Ирина", "Ксения", "Мария", "Надежда", "Оксана", "Софья", "Татьяна", "Юлия"]
surnames = ["Иванов", "Петров", "Сидоров", "Козлов", "Новиков", "Морозов", "Павлов", "Соловьев", "Волков", "Лебедев", "Смирнова", "Иванова", "Петрова", "Сидорова", "Козлова", "Новикова", "Морозова", "Павлова", "Соловьева", "Волкова", "Лебедева", "Сергеева"]

conn = psycopg2.connect(
    dbname="postgres",
    user="postgres",
    password="postgres",
    host="localhost",
    port="5432"
)

cur = conn.cursor()

cur.execute("""
    CREATE TABLE student (
        id SERIAL PRIMARY KEY,
        name VARCHAR(50),
        surname VARCHAR(50),
        birth_date VARCHAR(20),
        points INTEGER
    )
""")

for i in range(20):
    name = names[i]
    surname = surnames[i]
    birth_date = "{}/{}/{}".format(random.randint(1, 31), random.randint(1, 12), random.randint(1980, 2005))
    points = random.randint(1, 100)
    cur.execute("""
        INSERT INTO student (name, surname, birth_date, points)
        VALUES (%s, %s, %s, %s)
    """, (name, surname, birth_date, points))

conn.commit()

cur.close()
conn.close()