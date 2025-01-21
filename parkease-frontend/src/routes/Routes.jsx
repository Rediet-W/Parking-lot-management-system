import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "../pages/HomePage";
import Dashboard from "../pages/Dashboard";
import BookingPage from "../pages/BookingPage";

function AppRoutes() {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/dashboard" element={<Dashboard />} />
      <Route path="/book" element={<BookingPage />} />
    </Routes>
  );
}

export default AppRoutes;
