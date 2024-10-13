import { ResizableHandle, ResizablePanel, ResizablePanelGroup, } from "@/components/ui/resizable"
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar"
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle, } from "@/components/ui/card"
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs"
import { Input } from "@/components/ui/input"
import React from 'react';
import { ref } from 'react';
import { saveAs } from 'file-saver';

const emailName = 'testemail@gmail.com';

function Mail() {
  return (
    <div>
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
          <div className="h-screen w-fulPl">

          </div>
        </TabsContent>
        <TabsContent value="send-mail"> 
          <Input type="email" placeholder="Email" />
        </TabsContent>
      </Tabs>
    </div>
  );
}

function Sidebar() {
  return (
    <div className="grid grid-rows-10 bg-yellow-300 h-screen">
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
    <div className="grid grid-cols-4 h-screen w-screen">
     <div className="col-span-1"> <Sidebar /> </div>
      <div className="col-span-3" ><Inbox /> </div>
    </div>
   );
}

