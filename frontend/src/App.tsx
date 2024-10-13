import { ResizableHandle, ResizablePanel, ResizablePanelGroup, } from "@/components/ui/resizable"
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar"
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle, } from "@/components/ui/card"
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs"
import { Input } from "@/components/ui/input"
import { Textarea } from "@/components/ui/textarea"
import React from 'react';
import { ref } from 'react';
import { saveAs } from 'file-saver';
import { Label } from "@/components/ui/label"

const emailName = 'testemail@gmail.com';

function SendMail() {
  return (
    <div>
      <Input className="py-1" type="recipient-email" placeholder="Recipient: " />
      <Input className="py-1" type="email-subject" placeholder="Subject" />
      <div className="grid w-full gap-1.5 h-full m-2 mr-1">
        <Label htmlFor="message"> Your message </Label>
        <Textarea clsasName="h-full" placeholder="Type your message here." id="message" />
      </div>
    </div>
  );
}

function Mail() {
  return (
    <div className="py-1 pl-1 pr-1">
      <Card>
        <CardHeader> Email Title </CardHeader>
        <CardDescription> a whole bunch of words to fill out the content for this email blah blah blah blah blah
          blah blah blah blah blah blah blah...
        </CardDescription>
        <CardFooter className="justify-end"> 
          sent at 8:31
        </CardFooter>
      </Card>
    </div>
  );
}

function Inbox() {
  return(
    <div className="bg-teal-600 h-screen w-full">
      <Tabs defaultValue="inbox" className="w-full h-screen">
        <TabsList className="w-full justify-start">
          <TabsTrigger value="inbox"> Inbox </TabsTrigger>
          <TabsTrigger value="send-mail"> Send Mail </TabsTrigger>
        </TabsList>
        <TabsContent value="inbox">
          <div className="h-screen w-full">
            <Mail />
            <Mail />
            <Mail />
            <Mail />
            <Mail />
            <Mail />
            <Mail />
          </div>
        </TabsContent>
        <TabsContent value="send-mail"> 
          <SendMail />
        </TabsContent>
      </Tabs>
    </div>
  );
}

function Sidebar() {
  return (
    <div className="grid grid-rows-10 bg-yellow-300 ">
      <Card className="w-full">
        <CardHeader>
          <CardTitle className="justify-start"> Welcome </CardTitle>
        </CardHeader>
        <CardContent>
        <p> {emailName} </p>
        </CardContent>
      </Card>
      <div className="bg-purple-950 row-span-9">
        <Card className="w-full h-screen">
          <CardHeader>
            <CardTitle>Menu</CardTitle>
          </CardHeader>
          <CardContent>
          </CardContent>
        </Card>
      </div>
    </div>
  );
}


export default function App()  {
    return(
    <div className="grid grid-cols-4 h-full w-screen">
     <div className="col-span-1"> <Sidebar /> </div>
      <div className="col-span-3" ><Inbox /> </div>
    </div>
   );
}

