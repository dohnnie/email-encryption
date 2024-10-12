from email.message import EmailMessage
import ssl
import smtplib
#"zjmd esos bxgy xlpo"

sender =  "williamvinhtran01@gmail.com"
password =  "zjmdesosbxgyxlpo"
receiver =  "billvinhtran@gmail.com"

subject = "testing"
body = """testing 1 2 3 4 5 6 7 8 9 """

em = EmailMessage()
em['From'] = sender
em['To'] = receiver
em['Subject'] = subject
em.set_content(body)


context = ssl.create_default_context()

with smtplib.SMTP_SSL('smtp.gmail.com', 465, context=context) as smtp:
    smtp.login(sender, password)
    smtp.sendmail(sender, receiver, body)