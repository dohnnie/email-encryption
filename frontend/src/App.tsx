import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import { ResizableHandle, ResizablePanel, ResizablePanelGroup, } from "@/components/ui/resizable"
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar"
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle, } from "@/components/ui/card"
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/components/ui/tabs"

const emailName = 'testemail@gmail.com';


function Inbox() {
  return(
    <div className="bg-teal-600 h-screen">
      <Tabs defaultValue="inbox" className="w-[400px] h-screen">
        <TabsList>
          <TabsTrigger value="inbox"> Inbox </TabsTrigger>
          <TabsTrigger value="send-mail"> Send Mail </TabsTrigger>
        </TabsList>
        <TabsContent value="inbox"> Inbox Content here </TabsContent>
        <TabsContent value="send-mail"> Mail content goes here </TabsContent>
      </Tabs>
    </div>
  );
}

function Sidebar() {
  return (
    <div className="grid grid-rows-10 bg-yellow-300 h-screen">
      <Card className="w-[350px]">
        <CardHeader>
          <CardTitle> Welcome </CardTitle>
        </CardHeader>
        <CardContent>
        <p> {emailName} </p>
        </CardContent>
      </Card>
      <div className="bg-purple-950 row-span-9">
        This is another part
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

