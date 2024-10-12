import imaplib
import email

server =  "imap.gmail.com"
user =  "williamvinhtran01@gmail.com"
password =  "zjmdesosbxgyxlpo"

imap = imaplib.IMAP4_SSL(server)
imap.login(user, password)

imap.select("Inbox")

messages = imap.search(None, "ALL")

for m in messages[0].split():
    data = imap.fetch(m, "(RFC822)")

    print(data)