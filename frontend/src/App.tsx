import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import { ResizableHandle, ResizablePanel, ResizablePanelGroup, } from "@/components/ui/resizable"
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar"

function MailContents() {
 return (
  <div className="bg-purple-700">
      This is the mail contents
  </div>
 ); 
}

function Inbox() {
  return(
    <div className="bg-teal-600">
      This is the inbox
    </div>
  );
}

function Sidebar() {
  return (
    <div className="flex flex-col min-h-10 bg-yellow-300">
      This is the sidebar
    </div>
  );
}


function App()  {
    return(
    <div className="grid grid-cols-3 min-h-screen bg-pink-950" >
      <Sidebar className="" />
      <Inbox />
      <MailContents />
    </div>
   );
}

export default App;
