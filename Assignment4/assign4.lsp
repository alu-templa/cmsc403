;1 WORKS
(defun myList ()	;legit forgot this was a question considering the time and energy put into the others compared to this one
	(list (list 4 (list 7 22) "art" (list "math" (list 8) 99) 100)  )	
)

;2 WORKS
(defun leapYear (&optional (year 1800) (myList))
    (if (> year 2018)
        (RETURN-FROM leapYear myList)
    (if (or (and 
        (zerop (mod year 4))
        (not (zerop (mod year 100))))
        (zerop (mod year 400)))
			(leapYear (+ year 1) (cons myList year)) 
			(leapYear (+ year 1) myList)	;this was wierd, but it makes sence since there isn't a cons call here, without this the list doesn't do anything
    )
	)
)

;3 WORKS
(defun union- (L1 L2)
	(remove-duplicates 	;removes duplicates from L2. I don't believe that remove-duplicates is destructive as it is actually creating a new list that is a copy of the list that it removes elements from
		(if (endp L1) ;boole: if L1 is empty
			L2
			(union- (cdr L1)
				(adjoin (car L1) L2)	;adds (car L1) to L2 if its not already in L2
			)
		)
	)
)

;4 WORKS
(defun avg (aList &optional (sum 0) length))	;probably the easiest one
    (if (null aList)
        (/ sum length)
        (if (not length)
            (avg (cdr aList) (+ sum (car aList)) 
            (list-length aList))
	)
)

;5 WORKS
(defun isType (dataType)
    (lambda (data)(typep data dataType)) ;wasn't as hard as sevennnnnnn
)

;6 WORKS
(defun taxCalculator (limit rate value &optional list)
    (if (null value) (RETURN-FROM taxCalculator (reverse list)) )
	(if ( < limit (car value)) 
		(taxCalculator limit rate (cdr value) (cons (* rate (car value)) list) ) ;almost tail recursive
		(taxCalculator limit rate (cdr value) (cons (car value) list) )
	)
)

;7 MAYBE???
(defun clean (aFunc aList &optional bList)
    (if (null aList) (RETURN-FROM clean NIL))
    (if (listp (car aList) )
		(clean aFunc (cdr aList) (cons (clean aFunc (car bList))) )
		(clean aFunc (cdr aList) (cons (funcall aFunc (car bList))) )
	)
)

;8 WORKS
(defmacro threeWayBranch (x y toExecute)	;trust
	`(cond 
		((> ,x ,y) ,@(car toExecute) )
		((< ,x ,y) ,@(car (cdr toExecute) ) )
		((= ,x ,y) ,@(car (cdr (cdr toExecute) ) ) )
	)
)