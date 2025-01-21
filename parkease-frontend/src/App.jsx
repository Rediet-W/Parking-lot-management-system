import React from "react";
import AppRoutes from "./routes/routes.jsx";
import Navbar from "./components/NavBar.jsx";

function App() {
  return (
    <div className="min-h-screen bg-green-100 ">
      <Navbar />
      <AppRoutes />
    </div>
  );
}

export default App;
