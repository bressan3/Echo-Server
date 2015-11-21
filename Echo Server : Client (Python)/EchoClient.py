#Nome: LUCAS PAIVA BRESSAN
#Matricula: 201335063
#TRABALHO DE REDES DE COMPUTADORES

import socket

port = 4444
host = ''
screenName = 'Lucas'

#conecta ao servidor e abre os streams
socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
socket.connect((host, port))
print 'Connected to server on port ' + str(port)

#le da entrada padrao do teclado, envia e escreve resposta
while True:
	s = raw_input('Message: ')
	socket.send(s)
	if s == 'exit':
		break
	print 'Echo: [' + screenName + ']: ' + socket.recv(1024) + '\n'

#fecha conexao ao siar do while
print 'Closing connection to: ' + host
socket.close();