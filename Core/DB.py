# file: Core/DB.py
# ----------------------------------------------------------------------------
# MODULE: Crea las conexiones a la base de datos de MongoDB en base a la 
# variable de entorno "postgressql"
# ----------------------------------------------------------------------------

import psycopg2
from configparser import ConfigParser


# conecta a la base de datos
def connect_to_db(params):
    # connect to the PostgreSQL server
    conn = psycopg2.connect(**params)

    #retorna la conexión a la db y un cursor para realizar queries
    return conn, conn.cursor()


# hace una query a la base de datos
def make_query(cursor, query):
    cursor.execute(query)
    return cursor.fetchall()

# cierra la conexión a la base de datos
def close_conn_to_db(connection):
    connection.close()