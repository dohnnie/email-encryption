from email.message import EmailMessage
import ssl
import smtplib
import sys
#"zjmd esos bxgy xlpo"

sender =  "williamvinhtran01@gmail.com"
password =  "zjmdesosbxgyxlpo"
receiver =  sys.argv[1]

subject = sys.argv[2]
body = sys.argv[3]

em = EmailMessage()
em['From'] = sender
em['To'] = receiver
em['Subject'] = subject
em.set_content(body)


context = ssl.create_default_context()

with smtplib.SMTP_SSL('smtp.gmail.com', 465, context=context) as smtp:
    smtp.login(sender, password)
    smtp.sendmail(sender, receiver, em.as_string())