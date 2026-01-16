/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html","./src/**/*.{ts,tsx}"],
  theme: {
    extend: {
      colors: {
        brand: { 500: "#2a8fff", 600: "#1376e6" }
      }
    }
  },
  plugins: []
}