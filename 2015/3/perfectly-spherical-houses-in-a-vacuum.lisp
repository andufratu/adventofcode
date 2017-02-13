(in-package :cl-user)
(defpackage codes.andu.perfectly-spherical-houses-in-a-vacuum
  (:use :cl
        :prove))
(in-package :codes.andu.perfectly-spherical-houses-in-a-vacuum)

(defun visited-houses (instructions &optional (santas 1))
  (let ((visited 1)
		(visited-houses))
	(setf visited-houses (adjoin 0 visited-houses))
	(if (> (length instructions) 0)
		(visit-next instructions santas (make-list santas :initial-element 0) (make-list santas :initial-element 0) visited-houses visited)
		visited)))

(defun visit-next (instructions santas x-houses y-houses visited-houses visited-count)
  (loop for santa-index from 0 to (- santas 1) do
	 (let ((direction (if (> (length instructions) 0) (subseq instructions 0 1) ""))
			current-house
			(x-house (nth santa-index x-houses))
			(y-house (nth santa-index y-houses)))
	   (cond
		 ((string-equal direction "^")
		  (setf y-house (1+ y-house)))
		 ((string-equal direction ">")
		  (setf x-house (1+ x-house)))
		 ((string-equal direction "v")
		  (setf y-house (1- y-house)))
		 ((string-equal direction "<")
		  (setf x-house (1- x-house)))
		 (t nil))
	   (setf (nth santa-index x-houses) x-house)
	   (setf (nth santa-index y-houses) y-house)
	   (setf current-house (+ x-house (* 100000000 y-house)))
	   (if (not (member current-house visited-houses)) (setf visited-count (1+ visited-count)))
	   (setf visited-houses (adjoin current-house visited-houses))
	   (setf instructions (subseq instructions 1))))
  (if (> (length instructions) 0)
	  (visit-next instructions santas x-houses y-houses visited-houses visited-count)
	  visited-count))
