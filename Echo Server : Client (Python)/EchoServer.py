#Nome: LUCAS PAIVA BRESSAN
#Matricula: 201335063
#TRABALHO DE REDES DE COMPUTADORES

import socket
from thread import *

port = 4444
host = ''
#cria o socket 
clientSocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
print 'Socket created\n'
clientSocket.bind((host, port))
print 'Echo server created on port ' + str(port) + '\n'

#incia a escuta no socket
clientSocket.listen(True)

#funcao thread
def run(connection):
    print 'Accepted connection from client\n'
    
    while True:
        #recebe e responde o cliente (1024 e o tam max da mensagem)
        s = connection.recv(1024)
        if s == 'exit':
            break
        connection.send(s)
    #fecha a conexao ao sair do while
    print 'Closing connection with client'
    connection.close()
 
while 1:
    #espera blocante
    connection, address = clientSocket.accept()
    start_new_thread(run ,(connection,))

#fecha conexao do socket
clientSocket.close()