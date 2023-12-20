# image_processing.py
import cv2
import sys

def process_image(input_path, output_path):
    image = cv2.imread(input_path)
    
    # Apply Gaussian blur
    blurred_image = cv2.GaussianBlur(image, (5, 5), 0)

    # Convert to grayscale
    gray_image = cv2.cvtColor(blurred_image, cv2.COLOR_BGR2GRAY)
    
    # Apply Canny edge detection
    edges = cv2.Canny(gray_image, 50, 150)

    # Save the processed image
    cv2.imwrite(output_path, edges)

if __name__ == "__main__":
    # Command-line arguments: input_path output_path
    process_image(sys.argv[1], sys.argv[2])
