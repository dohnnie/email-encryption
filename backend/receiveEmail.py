import imaplib
import email

server =  "imap.gmail.com"
user =  "williamvinhtran01@gmail.com"
password =  "zjmdesosbxgyxlpo"

imap = imaplib.IMAP4_SSL(server)
imap.login(user, password)

imap.select("Inbox")

_, messages = imap.search(None, "ALL")

for m in messages[0].split():
    _, data = imap.fetch(m, "(RFC822)")

    mess = email.message_from_bytes(data[0][1])
    print(f"MessNum: {m}")
    print(f"From: {mess.get('From')}")
    print(f"To: {mess.get('To')}")
    print(f"Bcc: {mess.get('BCC')}")
    print(f"Data: {mess.get('Date')}")
    print(f"Subject: {mess.get('Subject')}")

    print("Content:")
    for part in mess.walk():
        if part.get_content_type() == "text/plain":
            print(part.as_string())