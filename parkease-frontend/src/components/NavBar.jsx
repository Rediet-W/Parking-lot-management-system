import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="bg-blue-600 text-white p-4">
      <div className="container mx-auto flex justify-between items-center">
        <h1 className="text-2xl font-bold">
          <Link to="/">ParkEase</Link>
        </h1>
        <ul className="flex space-x-6">
          <li>
            <Link to="/" className="hover:text-gray-300 font-bold">
              Home
            </Link>
          </li>
          <li>
            <Link to="/dashboard" className="hover:text-gray-300">
              Dashboard
            </Link>
          </li>
          <li>
            <Link to="/book" className="hover:text-gray-300">
              Book a Slot
            </Link>
          </li>
        </ul>
      </div>
    </nav>
  );
}

export default Navbar;
