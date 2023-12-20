// addRedPoints.js
document.addEventListener("DOMContentLoaded", function () {
  var processedImageContainer = document.getElementById(
    "imageProcessedContainer"
  );
  var redPoints = [];
  var angleLines = [];

  processedImageContainer.addEventListener("click", function (event) {
    var x = event.offsetX;
    var y = event.offsetY;

    // Add red point
    var redPoint = document.createElement("div");
    redPoint.className = "red-point";
    redPoint.style.left = x + "px";
    redPoint.style.top = y + "px";
    processedImageContainer.appendChild(redPoint);

    // Log position
    redPoints.push({ x: x, y: y });
    console.log("Red Point Added:", { x: x, y: y });

    // If 4 points are selected, calculate and draw the angle
    if (redPoints.length === 4) {
      drawLines(redPoints);
      var angle = calculateAngleBetweenLines(angleLines);
      console.log("Angle between lines:", angle);
    }
  });

  // Function to calculate the angle between two lines
  function calculateAngleBetweenLines(lines) {
    var line1 = lines[0];
    var line2 = lines[1];

    // Calculate the angle between two lines using their slopes
    var slope1 = (line1[1].y - line1[0].y) / (line1[1].x - line1[0].x);
    var slope2 = (line2[1].y - line2[0].y) / (line2[1].x - line2[0].x);

    // Calculate the angle in degrees
    var angle =
      Math.atan(Math.abs((slope2 - slope1) / (1 + slope1 * slope2))) *
      (180 / Math.PI);

    return angle;
  }

  // Function to draw lines between four points
  // Function to draw lines between four points
  function drawLines(points) {
    // Draw a green line between the first two points
    drawLine(points[0], points[1], "magenta");

    // Draw a blue line between the last two points
    drawLine(points[2], points[3], "magenta");

    // Store lines to calculate angle later
    angleLines = [points.slice(0, 2), points.slice(2, 4)];
  }

  /// Function to draw a line between two points with a specified color
function drawLine(start, end, color) {
    var line = document.createElement("div");
    line.className = "red-point"; // Use the same style as red points
  
    // Calculate the length and angle of the line
    var length = Math.sqrt(Math.pow(end.y - start.y, 2) + Math.pow(end.x - start.x, 2));
    var angle = calculateAngleBetweenPoints(start, end);
  
    // Set the position of the line relative to the image container
    line.style.position = "absolute";
    line.style.left = start.x + "px";
    line.style.top = start.y + "px";
  
    // Set the dimensions and rotation of the line
    line.style.width = length + "px";
    line.style.height = "1px"; // Adjust line height
    line.style.transformOrigin = "0 0"; // Rotate from the left
    line.style.transform = "rotate(" + angle + "deg)";
  
    // Set color based on the specified parameter or default to black
    line.style.backgroundColor = color || "black";
  
    processedImageContainer.appendChild(line);
    angleLines.push([start, end]);
  }
  

  // Function to calculate the angle between two points in degrees
  function calculateAngleBetweenPoints(start, end) {
    return Math.atan2(end.y - start.y, end.x - start.x) * (180 / Math.PI);
  }
});
