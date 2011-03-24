/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.calendar.service.base;

import com.liferay.calendar.model.CalendarEvent;
import com.liferay.calendar.service.CalendarBookingLocalService;
import com.liferay.calendar.service.CalendarEventLocalService;
import com.liferay.calendar.service.CalendarResourceLocalService;
import com.liferay.calendar.service.persistence.CalendarBookingPersistence;
import com.liferay.calendar.service.persistence.CalendarEventPersistence;
import com.liferay.calendar.service.persistence.CalendarResourcePersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the calendar event local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.calendar.service.impl.CalendarEventLocalServiceImpl}.
 * </p>
 *
 * @author Eduardo Lundgren
 * @see com.liferay.calendar.service.impl.CalendarEventLocalServiceImpl
 * @see com.liferay.calendar.service.CalendarEventLocalServiceUtil
 * @generated
 */
public abstract class CalendarEventLocalServiceBaseImpl
	implements CalendarEventLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.calendar.service.CalendarEventLocalServiceUtil} to access the calendar event local service.
	 */

	/**
	 * Adds the calendar event to the database. Also notifies the appropriate model listeners.
	 *
	 * @param calendarEvent the calendar event to add
	 * @return the calendar event that was added
	 * @throws SystemException if a system exception occurred
	 */
	public CalendarEvent addCalendarEvent(CalendarEvent calendarEvent)
		throws SystemException {
		calendarEvent.setNew(true);

		return calendarEventPersistence.update(calendarEvent, false);
	}

	/**
	 * Creates a new calendar event with the primary key. Does not add the calendar event to the database.
	 *
	 * @param calendarEventId the primary key for the new calendar event
	 * @return the new calendar event
	 */
	public CalendarEvent createCalendarEvent(long calendarEventId) {
		return calendarEventPersistence.create(calendarEventId);
	}

	/**
	 * Deletes the calendar event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param calendarEventId the primary key of the calendar event to delete
	 * @throws PortalException if a calendar event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteCalendarEvent(long calendarEventId)
		throws PortalException, SystemException {
		calendarEventPersistence.remove(calendarEventId);
	}

	/**
	 * Deletes the calendar event from the database. Also notifies the appropriate model listeners.
	 *
	 * @param calendarEvent the calendar event to delete
	 * @throws PortalException
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteCalendarEvent(CalendarEvent calendarEvent)
		throws PortalException, SystemException {
		calendarEventPersistence.remove(calendarEvent);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return calendarEventPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return calendarEventPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @param start the lower bound of the range of model instances to return
	 * @param end the upper bound of the range of model instances to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return calendarEventPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return calendarEventPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the calendar event with the primary key.
	 *
	 * @param calendarEventId the primary key of the calendar event to get
	 * @return the calendar event
	 * @throws PortalException if a calendar event with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalendarEvent getCalendarEvent(long calendarEventId)
		throws PortalException, SystemException {
		return calendarEventPersistence.findByPrimaryKey(calendarEventId);
	}

	/**
	 * Gets the calendar event with the UUID and group id.
	 *
	 * @param uuid the UUID of calendar event to get
	 * @param groupId the group id of the calendar event to get
	 * @return the calendar event
	 * @throws PortalException if a calendar event with the UUID and group id could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CalendarEvent getCalendarEventByUuidAndGroupId(String uuid,
		long groupId) throws PortalException, SystemException {
		return calendarEventPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Gets a range of all the calendar events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of calendar events to return
	 * @param end the upper bound of the range of calendar events to return (not inclusive)
	 * @return the range of calendar events
	 * @throws SystemException if a system exception occurred
	 */
	public List<CalendarEvent> getCalendarEvents(int start, int end)
		throws SystemException {
		return calendarEventPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of calendar events.
	 *
	 * @return the number of calendar events
	 * @throws SystemException if a system exception occurred
	 */
	public int getCalendarEventsCount() throws SystemException {
		return calendarEventPersistence.countAll();
	}

	/**
	 * Updates the calendar event in the database. Also notifies the appropriate model listeners.
	 *
	 * @param calendarEvent the calendar event to update
	 * @return the calendar event that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public CalendarEvent updateCalendarEvent(CalendarEvent calendarEvent)
		throws SystemException {
		calendarEvent.setNew(false);

		return calendarEventPersistence.update(calendarEvent, true);
	}

	/**
	 * Updates the calendar event in the database. Also notifies the appropriate model listeners.
	 *
	 * @param calendarEvent the calendar event to update
	 * @param merge whether to merge the calendar event with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the calendar event that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public CalendarEvent updateCalendarEvent(CalendarEvent calendarEvent,
		boolean merge) throws SystemException {
		calendarEvent.setNew(false);

		return calendarEventPersistence.update(calendarEvent, merge);
	}

	/**
	 * Gets the calendar booking local service.
	 *
	 * @return the calendar booking local service
	 */
	public CalendarBookingLocalService getCalendarBookingLocalService() {
		return calendarBookingLocalService;
	}

	/**
	 * Sets the calendar booking local service.
	 *
	 * @param calendarBookingLocalService the calendar booking local service
	 */
	public void setCalendarBookingLocalService(
		CalendarBookingLocalService calendarBookingLocalService) {
		this.calendarBookingLocalService = calendarBookingLocalService;
	}

	/**
	 * Gets the calendar booking persistence.
	 *
	 * @return the calendar booking persistence
	 */
	public CalendarBookingPersistence getCalendarBookingPersistence() {
		return calendarBookingPersistence;
	}

	/**
	 * Sets the calendar booking persistence.
	 *
	 * @param calendarBookingPersistence the calendar booking persistence
	 */
	public void setCalendarBookingPersistence(
		CalendarBookingPersistence calendarBookingPersistence) {
		this.calendarBookingPersistence = calendarBookingPersistence;
	}

	/**
	 * Gets the calendar event local service.
	 *
	 * @return the calendar event local service
	 */
	public CalendarEventLocalService getCalendarEventLocalService() {
		return calendarEventLocalService;
	}

	/**
	 * Sets the calendar event local service.
	 *
	 * @param calendarEventLocalService the calendar event local service
	 */
	public void setCalendarEventLocalService(
		CalendarEventLocalService calendarEventLocalService) {
		this.calendarEventLocalService = calendarEventLocalService;
	}

	/**
	 * Gets the calendar event persistence.
	 *
	 * @return the calendar event persistence
	 */
	public CalendarEventPersistence getCalendarEventPersistence() {
		return calendarEventPersistence;
	}

	/**
	 * Sets the calendar event persistence.
	 *
	 * @param calendarEventPersistence the calendar event persistence
	 */
	public void setCalendarEventPersistence(
		CalendarEventPersistence calendarEventPersistence) {
		this.calendarEventPersistence = calendarEventPersistence;
	}

	/**
	 * Gets the calendar resource local service.
	 *
	 * @return the calendar resource local service
	 */
	public CalendarResourceLocalService getCalendarResourceLocalService() {
		return calendarResourceLocalService;
	}

	/**
	 * Sets the calendar resource local service.
	 *
	 * @param calendarResourceLocalService the calendar resource local service
	 */
	public void setCalendarResourceLocalService(
		CalendarResourceLocalService calendarResourceLocalService) {
		this.calendarResourceLocalService = calendarResourceLocalService;
	}

	/**
	 * Gets the calendar resource persistence.
	 *
	 * @return the calendar resource persistence
	 */
	public CalendarResourcePersistence getCalendarResourcePersistence() {
		return calendarResourcePersistence;
	}

	/**
	 * Sets the calendar resource persistence.
	 *
	 * @param calendarResourcePersistence the calendar resource persistence
	 */
	public void setCalendarResourcePersistence(
		CalendarResourcePersistence calendarResourcePersistence) {
		this.calendarResourcePersistence = calendarResourcePersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Gets the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = calendarEventPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CalendarBookingLocalService.class)
	protected CalendarBookingLocalService calendarBookingLocalService;
	@BeanReference(type = CalendarBookingPersistence.class)
	protected CalendarBookingPersistence calendarBookingPersistence;
	@BeanReference(type = CalendarEventLocalService.class)
	protected CalendarEventLocalService calendarEventLocalService;
	@BeanReference(type = CalendarEventPersistence.class)
	protected CalendarEventPersistence calendarEventPersistence;
	@BeanReference(type = CalendarResourceLocalService.class)
	protected CalendarResourceLocalService calendarResourceLocalService;
	@BeanReference(type = CalendarResourcePersistence.class)
	protected CalendarResourcePersistence calendarResourcePersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
}